package com.ssafy.api.controller.api.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.dto.EmailDto;
import com.ssafy.api.request.EmailAuthPostReq;
import com.ssafy.api.request.EmailCheckPostReq;
import com.ssafy.api.request.QnAPostReq;
import com.ssafy.api.service.user.EmailService;
import com.ssafy.common.model.response.BaseResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "이메일 API", tags = {"Email"})
@RestController
@RequestMapping("/api/v3/email")
public class EmailController {
	@Autowired
    EmailService emailService;

    @PostMapping("/code") // 이메일 인증 코드 보내기
    @ApiOperation(value = "이메일", notes = "<strong> 인증 코드 </strong>를 통해 회원가입한다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
    public ResponseEntity<? extends BaseResponseBody> sendEmail(
    		@ApiParam(value="이메일 인증 정보", required = true) @RequestBody EmailAuthPostReq emailInfo){
    	EmailDto dto = emailService.createMailAndCode(emailInfo);
        emailService.mailSend(dto);
        
        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }
    
    @PostMapping("/QnA") // 이메일 인증 코드 확인하기
    @ApiOperation(value = "이메일로", notes = "<strong> Q&A </strong>를 보낸다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
    public ResponseEntity<? extends BaseResponseBody> sendQnAEmail(
    		@ApiParam(value="QnA 정보", required = true) @RequestBody QnAPostReq qnaInfo){
        
    	EmailDto dto = emailService.createMailAndQnA(qnaInfo);
    	emailService.qnaSend(dto);
    	
        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }
    
    @PostMapping("/check") // 이메일 인증 코드 확인하기
    @ApiOperation(value = "이메일", notes = "<strong> 인증 코드 </strong>를 통해 확인한다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
    public ResponseEntity<? extends BaseResponseBody> checkEmail(
    		@ApiParam(value="이메일 인증 정보", required = true) @RequestBody EmailCheckPostReq checkInfo){
        
    	boolean check=emailService.checkEmail(checkInfo);
        if(check==false) {
        	return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Fail"));
        }
        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }
}