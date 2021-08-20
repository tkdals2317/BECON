package com.ssafy.scheduler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.Hibernate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.Ticket;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.ConcertRepository;
import com.ssafy.db.repository.ConcertRepositorySupport;
import com.ssafy.db.repository.TicketRepository;

@Service
public class LmsService {
	@Autowired
	ConcertRepositorySupport concertRepositorySupport;
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	TicketRepository ticketRepository;
	
	public void concertWait() {
		concertRepository.updateWaitConcert();
	}
	
	public void concertStart() {
		concertRepository.updateStartConcert();
	}
	
	public void concertEnd() {
		concertRepository.updateEndConcert();
	}
	
	public void findConcerts() {
		List<Concert> list = concertRepository.findComingSoonConcert();
		for (Concert concert : list) {
			sendLMS(concert.getId());
		}
	}

	@Transactional(readOnly = true)
	public void sendLMS(Long concertId) {
		List<Ticket> list = ticketRepository.findByConcertId(concertId).get();
		Hibernate.initialize(list);
		try {
			for (Ticket ticket : list) {
				sendCode(ticket);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void sendCode(Ticket ticket) throws Exception {
		Concert concert = ticket.getConcert();
		User user = ticket.getUser();
		
		String name = user.getName();
		String phone = user.getPhone().replace("-", "");
		
		String title = concert.getTitle();
		String startTime = concert.getStartTime();
		String endTime = concert.getEndTime();
		
		StringBuilder message = new StringBuilder();
		message.append("[알림]").append(name).append("님, 공연이 곧 시작됩니다.\n\n")
			.append("- 공연명 : ").append(title).append("\n")
			.append("- 좌석 : ").append(ticket.getType()).append("\n")
			.append("- 일시 : ").append(startTime).append(" ~ ").append(endTime).append("\n")
			.append("- 티켓 : ").append(ticket.getCode());

		// 문자 발송
		String hostNameUrl = "https://sens.apigw.ntruss.com"; // 호스트 URL
		String requestUrl = "/sms/v2/services/"; // 요청 URL
		String requestUrlType = "/messages"; // 요청 URL
		String accessKey = "kj27j1drWzMcCrIeDwLZ"; // 네이버 클라우드 플랫폼 회원에게 발급되는 개인 인증키
		String secretKey = "8EJJzz6ZtdDat3ov4W49HHqbW8cqLNgP5NmZLvA1"; // 2차 인증을 위해 서비스마다 할당되는 service secret
		String serviceId = "ncp:sms:kr:270803685778:be-con"; // 프로젝트에 할당된 SMS 서비스 ID
		String method = "POST"; // 요청 method
		String timestamp = Long.toString(System.currentTimeMillis()); // current timestamp (epoch)
		requestUrl += serviceId + requestUrlType;
		String apiUrl = hostNameUrl + requestUrl;

		// JSON 을 활용한 body data 생성

		JSONObject bodyJson = new JSONObject();
		JSONObject toJson = new JSONObject();
		JSONArray toArr = new JSONArray();

		toJson.put("subject", "Be-Con"); // 메시지 제목 * LMS Type에서만 사용할 수 있습니다.
		toJson.put("content", message.toString()); // 메시지 내용 * Type별로 최대 byte 제한이
																					// 다릅니다.* SMS: 80byte / LMS:
																					// 2000byte
		toJson.put("to", phone); // 수신번호 목록 * 최대 50개까지 한번에 전송할 수 있습니다.
		toArr.add(toJson);

		bodyJson.put("type", "lms"); // 메시지 Type (sms | lms)
		bodyJson.put("contentType", "COMM"); // 메시지 내용 Type (AD | COMM) * AD: 광고용, COMM: 일반용 (default: COMM) *
												// 광고용 메시지 발송 시 불법 스팸 방지를 위한 정보통신망법 (제 50조)가 적용됩니다.
		bodyJson.put("countryCode", "82"); // 국가 전화번호
		bodyJson.put("from", "01024384535"); // 발신번호 * 사전에 인증/등록된 번호만 사용할 수 있습니다.
		bodyJson.put("subject", ""); // 메시지 제목 * LMS Type에서만 사용할 수 있습니다.
		bodyJson.put("content", message.toString()); // 메시지 내용 * Type별로 최대 byte 제한이 다릅니다.* SMS: 80byte /
															// LMS: 2000byte
		bodyJson.put("messages", toArr);

		String body = bodyJson.toJSONString();

		URL url = new URL(apiUrl);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setUseCaches(false);
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("content-type", "application/json");
		con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
		con.setRequestProperty("x-ncp-iam-access-key", accessKey);
		con.setRequestProperty("x-ncp-apigw-signature-v2",
				makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
		con.setRequestMethod(method);
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(body.getBytes());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 202) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		System.out.println(response.toString());
		br.close();
	}

	public static String makeSignature(String url, String timestamp, String method, String accessKey, String secretKey)
			throws NoSuchAlgorithmException, InvalidKeyException {
		String space = " "; // one space
		String newLine = "\n"; // new line

		String message = new StringBuilder().append(method).append(space).append(url).append(newLine).append(timestamp)
				.append(newLine).append(accessKey).toString();

		SecretKeySpec signingKey;
		String encodeBase64String;
		try {

			signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			encodeBase64String = e.toString();
		}

		return encodeBase64String;
	}
}
