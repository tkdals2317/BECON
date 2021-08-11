package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TicketPostRequest")
public class TicketPostReq {
	@ApiModelProperty(name="티켓 구매 날짜", example="2021-08-03 11:00")
	String buyDate;
	@ApiModelProperty(name="티켓 구매 가격", example="13000")
	int price;
	@ApiModelProperty(name="티켓 종류", example="VIP")
	String type;
	@ApiModelProperty(name="공연 번호", example="1")
	Long concertId;
	
}
