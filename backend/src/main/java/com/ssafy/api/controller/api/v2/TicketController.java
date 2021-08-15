package com.ssafy.api.controller.api.v2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ssafy.api.request.TicketPostReq;
import com.ssafy.api.service.ticket.TicketService;
import com.ssafy.api.service.user.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Ticket;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "티켓 API", tags = {"Ticket"})
@RestController
@RequestMapping("/api/v2/ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
	@Autowired
	UserService userService;
	
	@PostMapping("/buy")
	@ApiOperation(value = "티켓 구매", notes = "티켓을 구매하는 Controller") 
	@ApiResponses({
		@ApiResponse(code = 201, message = "성공"),
		@ApiResponse(code = 409, message = "실패")
	})
	public ResponseEntity<? extends BaseResponseBody> register(
			@ApiIgnore Authentication authentication,
			@ApiParam(value="티켓 정보", required = true) @RequestBody TicketPostReq ticketInfo
			//@ApiParam(value="공연 아이디", required = true) Long concertId
			/*@ApiParam(value="유저 아이디", required = true) String userId*/){
		System.out.println(ticketInfo.getBuyDate());
		System.out.println(ticketInfo.getBuyDate());
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();

		Ticket ticket=null;
		try{
			User user=userService.getUserByUserId(userDetails.getUsername()); 
			ticket=ticketService.buyTicket(ticketInfo, user);
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
	
	@GetMapping("/{userId}")
	@ApiOperation(value = "내가 구매한 티켓 리스트를 반환한다")
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
        @ApiResponse(code = 210, message = "구매 정보 없음")
    })
	public ResponseEntity<?> getMyTicket(
			/* @ApiIgnore Authentication authentication, */
			@PathVariable String userId){
		
		//SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		//String userId = userDetails.getUsername();
		User user=userService.getUserByUserId(userId); 
		Optional<List<Ticket>> ticketList=null;
		try {
			ticketList=ticketService.findTicketBuy(user);
			if(Optional.empty() == null) {
				return ResponseEntity.status(210).body(BaseResponseBody.of(210, "컨텐츠가 없습니다"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(403).body(BaseResponseBody.of(403, "잘못된 접근입니다."));
		}

		return ResponseEntity.status(201).body(ticketList);	
	}
	
	@GetMapping("/count/total")
	@ApiOperation(value = "전체 티켓 수 조회", notes = "전체 티켓 수를 조회한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 210, message = "구매 정보 없음")
    })
	public ResponseEntity<?> getTotalUser() {	 
		Long total = ticketService.getTotalTicket();
		return ResponseEntity.status(200).body(total);
	}
}

