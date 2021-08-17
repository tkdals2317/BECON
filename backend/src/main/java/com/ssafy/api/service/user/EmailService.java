package com.ssafy.api.service.user;

import java.util.Optional;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.EmailDto;
import com.ssafy.api.request.EmailAuthPostReq;
import com.ssafy.api.request.EmailCheckPostReq;
import com.ssafy.api.request.QnAPostReq;
import com.ssafy.db.entity.Email;
import com.ssafy.db.repository.EmailRepository;
import com.ssafy.db.repository.EmailRepositorySupport;
import com.ssafy.db.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {

	@Autowired
    UserRepository userRepository;
	@Autowired
	EmailRepository emailRepository;
	@Autowired
	EmailRepositorySupport emailRepositorySupport;
	@Autowired
    JavaMailSender mailSender;
	
    private static final String FROM_ADDRESS = "cherrykang97@gmail.com";

    public EmailDto createMailAndCode(EmailAuthPostReq emailInfo){
        String str = getTempPassword();
        String message = "<html> <body><b>안녕하세요!</b><br>";
        message +="이메일 인증 코드 안내 이메일 입니다.<br>";
        message +="["+emailInfo.getName()+"]님의 인증 코드는 ";
        message +="<font color=red>"+str+"</font> 입니다.</body></html>";
        EmailDto dto = new EmailDto();
        dto.setAddress(emailInfo.getEmail());
        dto.setTitle(emailInfo.getName()+"님의 이메일 인증 코드 안내 이메일 입니다.");
        dto.setMessage(message);
        
        Email email = new Email();
        email.setCode(str);
        email.setUserEmail(emailInfo.getEmail());
        email.setUserId(emailInfo.getUserId());
        
        saveEmail(email);
		return dto;
    }
    
    public EmailDto createMailAndQnA(QnAPostReq qnaInfo){
    	String title = qnaInfo.getName()+"님께서 보내신 문의사항 입니다.";
        String message = "<html> <body><b>제목</b><br>";
        message +=qnaInfo.getTitle()+"<br>";
        message +="<b>내용</b><br>";
        message +=qnaInfo.getContent()+"<br>";
        message +="<b>보낸 이</b><br>";
        message +=qnaInfo.getEmail()+"</body></html>";
        
        EmailDto dto = new EmailDto();
        dto.setAddress(EmailService.FROM_ADDRESS);
        dto.setTitle(title);
        dto.setMessage(message);
       
		return dto;
    }

    public void saveEmail(Email email) {
    	Email exist=emailRepositorySupport.findByUserId(email.getUserId());
    	if(exist==null) {
    		emailRepository.save(email);
    	}else {
    		emailRepository.delete(exist);
    		emailRepository.save(email);
    	}
    }

    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
    
    public void mailSend(EmailDto emailDto){
        MimeMessage message = mailSender.createMimeMessage();
        try {
			message.setRecipients(RecipientType.TO, emailDto.getAddress());
			message.setFrom(EmailService.FROM_ADDRESS);
			message.setSubject(emailDto.getTitle());
			message.setText(emailDto.getMessage(),"UTF-8", "html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        mailSender.send(message);
    }
    
    public void qnaSend(EmailDto emailDto){
        MimeMessage message = mailSender.createMimeMessage();
        try {
			message.setRecipients(RecipientType.TO, EmailService.FROM_ADDRESS);
			message.setFrom(emailDto.getAddress());
			message.setSubject(emailDto.getTitle());
			message.setText(emailDto.getMessage(),"UTF-8", "html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        mailSender.send(message);
    }
    
    public boolean checkEmail(EmailCheckPostReq checkInfo) {
    	String checkCode=emailRepositorySupport.findCodeByUserId(checkInfo.getUserId());
    	if(checkInfo.getCode().equals(checkCode)) {
    		return true;
    	}
    	return false;
    }
}