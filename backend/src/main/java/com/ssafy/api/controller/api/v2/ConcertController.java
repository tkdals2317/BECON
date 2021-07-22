package com.ssafy.api.controller.api.v2;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.api.service.concert.ConcertCategoryService;
import com.ssafy.api.service.concert.ConcertService;
import com.ssafy.api.service.concert.ConcertThumbnailService;
import com.ssafy.api.service.user.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.MD5Generator;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "공연 API", tags = {"Concert"})
@RestController
@RequestMapping("/api/v2/concert")
public class ConcertController {
	@Autowired
	ConcertService concertService;
	@Autowired
	UserService userService;
	@Autowired
	ConcertThumbnailService concertThumbnailService;
	@Autowired
	ConcertCategoryService concertCategoryService;
	
	@PostMapping("/regist")
	@ApiOperation(value = "공연 신청", notes = "공연을 신청을 한다.") 
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@ApiParam(value="공연 신청 정보", required = true) ConcertRegisterPostReq registerInfo, 
			@ApiParam(value="공연 포스터", required = true) MultipartFile files,
			@ApiParam(value="공연 신청자 아이디", required = true) String userId,
			@ApiParam(value="공연 카테고리", required = true) String category){
		Concert concert;
		try{
			String origFilename = files.getOriginalFilename();
	        String filename = new MD5Generator(origFilename).toString();
	        String savePath = System.getProperty("user.dir") + "\\files";
	        if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
			System.out.println(origFilename);
			System.out.println(registerInfo.getDescription());
	        String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));
            
            ConcertThumbnailPostReq concertTumbnailInfo=new ConcertThumbnailPostReq();
            concertTumbnailInfo.setOriginName(origFilename);
            concertTumbnailInfo.setName(filename);
            concertTumbnailInfo.setPath(filePath);
            
            ConcertThumbnail fileId = concertThumbnailService.saveFile(concertTumbnailInfo);
            User user = userService.getUserByUserId(userId);
            ConcertCategory categoryId=concertCategoryService.getCategoryByCategoryId(category);
            concert = concertService.createUser(registerInfo, fileId, user, categoryId);
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
	
	
}
