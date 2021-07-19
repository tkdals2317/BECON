package com.ssafy.api.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.ConferenceRegisterPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.service.ConferenceService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "회의방 API", tags = {"Conference"})
@RestController
@RequestMapping("/api/v1/conference")
public class ConferenceController {
	@Autowired
	ConferenceService conferenceservcie;
	
	@PostMapping("/regist")
	@ApiOperation(value = "화상회의 방 만들기", notes = "화상회의 방을 생성한다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="화상회의 방 정보", required = true) ConferenceRegisterPostReq registInfo) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
		Conference conference;
		try{
			conference = conferenceservcie.createConference(registInfo);
		}catch(SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		}catch(TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		}catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		}
		return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
	}
}
