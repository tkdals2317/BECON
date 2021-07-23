package com.ssafy.api.controller.api.v2;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.api.response.ConcertDetailRes;
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
import com.ssafy.db.entity.UserConcert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

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
	public ResponseEntity<? extends BaseResponseBody> regist(
			@ApiParam(value="공연 신청 정보", required = true) ConcertRegisterPostReq registerInfo, 
			@ApiParam(value="공연 포스터", required = true) MultipartFile files,
			@ApiParam(value="공연 신청자 아이디", required = true) String userId,
			@ApiParam(value="공연 카테고리", required = true) String category){
		System.out.println(userId);
		Concert concert = null;
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
            concert = concertService.createConcert(registerInfo, fileId, user, categoryId);
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
	
	@GetMapping("/findByCategory/{category}")
	@ApiOperation(value = "조건에 맞게 콘서트 리스트를 반환한다")
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
        @ApiResponse(code = 210, message = "공연 정보 없음")
    })
	public ResponseEntity<?> findByCategory(@ApiIgnore @PathVariable String category){
		System.out.println(category);
		List<Concert> concertList = null;
		try {
			if(category.equals("전체")) {
				System.out.println("category");
				concertList = concertService.findConcerts();
			}else {
				ConcertCategory categoryId = concertCategoryService.getCategoryByCategoryId(category);
				System.out.println(category + " " +categoryId.getId());
				concertList = concertService.findByCategory(categoryId.getId());
			}
			if(concertList.size()==0) {
				return ResponseEntity.status(210).body(BaseResponseBody.of(210, "컨텐츠가 없습니다"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}

		return ResponseEntity.status(201).body(concertList);	
	}
	@GetMapping("/findByOwnerId/{OwnerId}")
	@ApiOperation(value = "조건에 맞게 콘서트 리스트를 반환한다")
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
        @ApiResponse(code = 210, message = "공연 정보 없음")
    })
	public ResponseEntity<?> findByOwnerId(@ApiIgnore @PathVariable String OwnerId){	
		Optional<List<Concert>> concertList = null;
		System.out.println(OwnerId);
		try {
			concertList = concertService.getConcertByOwnerId(OwnerId);
			System.out.println();
			
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}
		return ResponseEntity.status(201).body(concertList);

	}
	
	@GetMapping("/{concertId}")
	@ApiOperation(value = "concertId에 해당하는 콘서트 상세정보를 반환한다")
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
        @ApiResponse(code = 403, message = "잘못된 접근입니다.")
    })
	public ResponseEntity<?> getConcertByConcertId(@ApiIgnore @PathVariable Long concertId){	
		Optional<Concert> concert = null;
		Optional<List<UserConcert>> userConcert = null;
		try {
			concert = concertService.getConcertByConcertId(concertId);
			userConcert= concertService.getUserConcertByConcerId(concertId);
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}
	
		return ResponseEntity.status(201).body(ConcertDetailRes.of(concert, userConcert));
	}
}
