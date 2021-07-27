package com.ssafy.api.controller.api.v1;

import java.io.File;
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
import com.ssafy.api.service.user.UserProfileService;
import com.ssafy.api.service.user.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.MD5Generator;
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
		UserProfilePostReq userProfileInfo = null;
		try{
			if(files!= null) {
				String origFilename = files.getOriginalFilename();
		        String filename = new MD5Generator(origFilename).toString();
		        String savePath = "C:\\Users\\multicampus\\git\\S05P12D102\\frontend\\files";
		        if (!new File(savePath).exists()) {
	                try{
	                    new File(savePath).mkdir();
	                }
	                catch(Exception e){
	                    e.getStackTrace();
	                }
	            }
		        String filePath = savePath + "\\" + filename;
	            files.transferTo(new File(filePath));
	            
	            userProfileInfo=new UserProfilePostReq();
	            userProfileInfo.setOriginName(origFilename);
	            userProfileInfo.setName(filename);
	            userProfileInfo.setPath(filePath);
			}else {
				userProfileInfo=new UserProfilePostReq();
	            userProfileInfo.setOriginName("BeCon.jfif");
	            userProfileInfo.setName("5887b47695b084b04d2e575438d5a794");
	            userProfileInfo.setPath("C:\\Users\\multicampus\\git\\S05P12D102\\frontend\\files\\5887b47695b084b04d2e575438d5a794");
			}
            UserProfile fileId = userProfileService.saveFile(userProfileInfo);
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
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
		 * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
		 */
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
			@ApiParam(value="회원 정보 수정", required = true) UserModifyPostReq request) {
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
		 * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
		 */

		 SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		 String existId = userDetails.getUsername(); System.out.println(existId);

		long rows = 0;
		User user = userService.getUserByUserId(userId);
		//프로필 변경이 있을 경우	
		try{
			if(!files.isEmpty()) {
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
		if (rows > 0 /* && existId==userId */) {
			return ResponseEntity.status(200).body(UserModifyPostRes.of(200, "Success"));
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
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
		 * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
		 */
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String existId = userDetails.getUsername();
		Optional<User> rows;
		try{
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
