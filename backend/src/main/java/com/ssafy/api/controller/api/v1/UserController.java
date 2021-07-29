package com.ssafy.api.controller.api.v1;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.UserModifyPostReq;
import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserModifyPostRes;
import com.ssafy.api.response.UserRes;
import com.ssafy.api.service.concert.ConcertService;
import com.ssafy.api.service.user.UserProfileService;
import com.ssafy.api.service.user.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.MD5Generator;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserProfile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ConcertService concertService;
	@Autowired
	UserProfileService userProfileService;
	
	@PostMapping("/regist")
	@ApiOperation(value = "회원 가입", notes = "<strong>아이디와  패스워드</strong>를 통해 회원가입 한다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@ApiParam(value="회원가입 정보", required = true) UserRegisterPostReq registerInfo, 
			@ApiParam(value="imgUrlBase", required = false) MultipartFile files){
		User user;
		try{
            UserProfile fileId = userProfileService.saveFile(userProfileService.setFile(files));
			user = userService.createUser(registerInfo, fileId);
		}catch(SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		}catch(TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		}catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		}catch(Exception e) {
            e.printStackTrace();
        }
		return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
	}
	
	@GetMapping("/{userid}")
	@ApiOperation(value = "유저 정보 (존재하는 회원 확인용)", notes = "<strong>아이디가 중복인지</strong>확인 한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 409, message = "실패")
    })
	public ResponseEntity<? extends BaseResponseBody> duplicate(
			@PathVariable @ApiParam(value="아이디 중복확인", required = true) String userid) {
		boolean check;
		try{
			check=userService.duplicateUserId(userid);
		}catch(SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		}catch(TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		}catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		}
		if(check==false) {
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "사용 가능한 아이디 입니다."));
		}
		return ResponseEntity.status(409).body(BaseResponseBody.of(409, "이미 존재하는 사용자 ID 입니다."));
	}
	
	@GetMapping("/me")
	@ApiOperation(value = "회원 본인 정보 조회", notes = "로그인한 회원 본인의 정보를 응답한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
	public ResponseEntity<UserRes> getUserInfo(
			@ApiIgnore Authentication authentication) {
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		 
		String userId = userDetails.getUsername();
		User user = userService.getUserByUserId(userId);
		return ResponseEntity.status(200).body(UserRes.of(user));
	}
	@PatchMapping("/{userId}")
	@ApiOperation(value = "회원 정보 수정", notes = "로그인한 회원 본인의 정보를 수정한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
	public ResponseEntity<? extends BaseResponseBody> modify(
			@ApiIgnore Authentication authentication,
			@PathVariable("userId") @ApiParam(value="회원 아이디", required = true) String userId,
			@ApiParam(value="imgUrlBase", required = true) MultipartFile files,
			@ApiParam(value="회원 정보 수정", required = false) UserModifyPostReq request) {
		 SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		 String existId = userDetails.getUsername(); System.out.println(existId);

		long rows = 0;
		User user = userService.getUserByUserId(userId);
		try{
			if(files!=null) {
	            Long userPID=user.getUserProfile().getId();
	            userProfileService.changeFile(userPID, files);
	        }
			rows = userService.modifyUser(userId, request);
		}catch(SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		}catch(TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		}catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		}catch(Exception e) {
            e.printStackTrace();
        }
		if (rows > 0) {
			return ResponseEntity.status(200).body(UserRes.of(user));
		}
		return ResponseEntity.status(200).body(UserModifyPostRes.of(200, "Fail"));
	}
	
	
	@DeleteMapping("/{userId}")
	@ApiOperation(value = "회원 정보 삭제", notes = "로그인한 회원 본인의 정보를 삭제한다.") 
    @ApiResponses({
        @ApiResponse(code = 204, message = "성공"),
    })
	public ResponseEntity<? extends BaseResponseBody> delete(
			@ApiIgnore Authentication authentication,
			@PathVariable("userId") @ApiParam(value="회원 아이디", required = true) String userId) {
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String existId = userDetails.getUsername();
		Optional<User> rows;
		try{
			System.out.println(userId);
			//관련된 콘서트 삭제
			concertService.deleteConcertByOwnerId(userId);
			
		
			System.out.println("콘서트 삭제?");
			rows = userService.deleteUser(userId);
		}catch(SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		}catch(TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		}catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		}
		if (rows.isPresent() && existId==userId) {
			return ResponseEntity.status(204).body(BaseResponseBody.of(204, "Success"));
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Fail"));
	}
}
