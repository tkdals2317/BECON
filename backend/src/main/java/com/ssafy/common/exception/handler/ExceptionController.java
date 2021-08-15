package com.ssafy.common.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.common.model.response.BaseResponseBody;


@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({SignatureVerificationException.class,JWTDecodeException.class}) 
	public ResponseEntity<? extends BaseResponseBody> SJE(Exception e) { 
		return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
	}
	@ExceptionHandler(TokenExpiredException.class) 
	public ResponseEntity<? extends BaseResponseBody> TE (TokenExpiredException e) { 
		return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
	}
	@ExceptionHandler(Forbidden.class) 
	public ResponseEntity<? extends BaseResponseBody> FE (Forbidden e) { 
		return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근 권한이 없습니다."));
	}
}
