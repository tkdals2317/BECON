package com.ssafy.api.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ConcertRegisterPostRequest")
public class ConcertRegisterPostReq {
	@ApiModelProperty(name="공연 title", example="ssafy_web")
	String title;
	@ApiModelProperty(name="공연 descipton", example="ssafy_web")
	String description;
	@ApiModelProperty(name="공연 startTime", example="ssafy_web")
	String startTime;
	@ApiModelProperty(name="공연 endTime", example="ssafy_web")
	String endTime;
	@ApiModelProperty(name="공연 priceStand", example="ssafy_web")
	Integer priceStand;
	@ApiModelProperty(name="공연 priceVip", example="ssafy_web")
	Integer priceVip;
}
