package com.ssafy.api.controller.api.v2;

import java.util.Comparator;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.api.response.ConcertDetailRes;
import com.ssafy.api.response.ConcertRes;
import com.ssafy.api.service.concert.ConcertCategoryService;
import com.ssafy.api.service.concert.ConcertPosterService;
import com.ssafy.api.service.concert.ConcertService;
import com.ssafy.api.service.concert.ConcertThumbnailService;
import com.ssafy.api.service.user.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserConcert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "공연 API", tags = { "Concert" })
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
	ConcertPosterService concertPosterService;
	@Autowired
	ConcertCategoryService concertCategoryService;

	@GetMapping("/concert-categories")
	@ApiOperation(value = "공연 카테고리", notes = "DB에 등록된 공연 카테고리들을 조회한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), })
	public ResponseEntity<?> getConcertCategory() {
		Optional<List<ConcertCategory>> categories = concertCategoryService.getConcertCategory();
		System.out.println(categories);
		return ResponseEntity.status(201).body(categories.get());
	}

	@PostMapping("/regist")
	@ApiOperation(value = "공연 신청", notes = "공연을 신청을 한다.")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), })
	public ResponseEntity<? extends BaseResponseBody> regist(
			@ApiIgnore Authentication authentication,
			@ApiParam(value = "공연 신청 정보", required = true) ConcertRegisterPostReq registerInfo,
			@ApiParam(value = "공연 포스터", required = true) MultipartFile files1,
			@ApiParam(value = "공연 포스터", required = true) MultipartFile files2) {
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String userId = userDetails.getUsername();
		Concert concert = new Concert();
		try {
			ConcertPoster posterId = concertPosterService.saveFile(concertPosterService.setFile(files1));
			ConcertThumbnail thumbNailId = concertThumbnailService.saveFile(concertThumbnailService.setFile(files2));
			User user = userService.getUserByUserId(userId);
			ConcertCategory category = concertCategoryService.getCategoryByCategoryId(registerInfo.getCategoryName());
			concert = concertService.createConcert(registerInfo, posterId, thumbNailId, user, category);
		} catch (SignatureVerificationException | JWTDecodeException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 유효하지 않습니다."));
		} catch (TokenExpiredException e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "세션이 만료되었습니다."));
		} catch (Forbidden e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "접근권한이 없습니다."));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(201).body(ConcertRes.of(concert));
	}

	@GetMapping("/findByCategory/{category}")
	@ApiOperation(value = "조건에 맞게 콘서트 리스트를 반환한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), @ApiResponse(code = 210, message = "공연 정보 없음") })
	public ResponseEntity<?> findByCategory(
			/* @ApiIgnore Authentication authentication, */
			@PathVariable String category) {
		System.out.println(category);
		List<Concert> concertList = null;
		try {
			if (category.equals("All")) {
				concertList = concertService.findConcerts();

			} else {
				ConcertCategory categoryId = concertCategoryService.getCategoryByCategoryId(category);
				System.out.println(category + " " + categoryId.getId());
				concertList = concertService.findByCategory(categoryId.getId());
			}
			if (concertList.size() == 0) {
				return ResponseEntity.status(210).body(BaseResponseBody.of(210, "컨텐츠가 없습니다"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}

		return ResponseEntity.status(201).body(concertList);
	}

	@GetMapping("/findByOwnerId")
	@ApiOperation(value = "조건에 맞게 콘서트 리스트를 반환한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), @ApiResponse(code = 210, message = "공연 정보 없음") })
	public ResponseEntity<?> findByOwnerId(@ApiIgnore Authentication authentication) {
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String userId = userDetails.getUsername();
		Optional<List<Concert>> concertList = null;
		System.out.println(userId);
		try {
			concertList = concertService.getConcertByOwnerId(userId);
			System.out.println();

		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}
		return ResponseEntity.status(201).body(concertList);

	}

	@GetMapping("/{concertId}")
	@ApiOperation(value = "concertId에 해당하는 콘서트 상세정보를 조회한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), @ApiResponse(code = 403, message = "잘못된 접근입니다.") })
	public ResponseEntity<?> getConcertByConcertId(
			/* @ApiIgnore Authentication authentication, */
			@PathVariable Long concertId) {
		Optional<Concert> concert = null;
		Optional<List<UserConcert>> userConcert = null;
		try {
			concert = concertService.getConcertByConcertId(concertId);
			userConcert = concertService.getUserConcertByConcerId(concertId);
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}

		return ResponseEntity.status(201).body(ConcertDetailRes.of(concert, userConcert));
	}

	@PatchMapping("/{concertId}")
	@ApiOperation(value = "공연 정보 수정", notes = "concertId에 해당하는 콘서트의 정보를 수정한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), @ApiResponse(code = 403, message = "잘못된 접근입니다.") })
	public ResponseEntity<? extends BaseResponseBody> modify(@ApiIgnore Authentication authentication,
			@ApiParam(value = "concertId") @PathVariable Long concertId,
			@ApiParam(value = "imgUrlBase", required = true) MultipartFile files,
			@ApiParam(value = "콘서트 정보 수정 내용", required = true) Concert request) {

		return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
	}

	@DeleteMapping("/{concertId}")
	@ApiOperation(value = "공연 정보 삭제", notes = "{concertId}에 해당하는 공연 정보를 삭제한다.")
	@ApiResponses({ @ApiResponse(code = 204, message = "성공"), })
	public ResponseEntity<? extends BaseResponseBody> delete(
			/* @ApiIgnore Authentication authentication, */
			@PathVariable("concertId") @ApiParam(value = "공연 아이디", required = true) Long concertId) {

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Fail"));
	}

	@GetMapping("/findComing")
	@ApiOperation(value = "진행예정인 콘서트 리스트를 반환한다")
	@ApiResponses({ @ApiResponse(code = 201, message = "성공"), @ApiResponse(code = 210, message = "공연 정보 없음") })
	public ResponseEntity<?> findComing() {
		List<Concert> concertList = null;
		try {
			concertList = concertService.findComingConcerts();
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}
		return ResponseEntity.status(201).body(concertList);
	}
	
	@GetMapping("/count/total")
	@ApiOperation(value = "전체 콘서트 수 조회", notes = "전체 콘서트 수를 조회한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
	public ResponseEntity<Long> getTotalConcert() {	 
		Long total = concertService.getTotalConcert();
		return ResponseEntity.status(200).body(total);
	}
	
	@GetMapping("/count/playing")
	@ApiOperation(value = "진행중인 콘서트 수 조회", notes = "현재 진행중인 콘서트 수를 조회한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
	public ResponseEntity<Long> getIngConcert() {	 
		Long total = concertService.getIngConcert();
		return ResponseEntity.status(200).body(total);
	}
}
