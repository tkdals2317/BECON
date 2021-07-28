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
	@ApiModelProperty(name="공연 title", example="프리스타일 힙합 쇼")
	String title;
	@ApiModelProperty(name="공연 description", example="프리스타일로 힙합 공연을 해보자")
	String description;
	@ApiModelProperty(name="공연 startTime", example="2021-07-26 18:00")
	String startTime;
	@ApiModelProperty(name="공연 endTime", example="2021-07-26 20:00")
	String endTime;
	@ApiModelProperty(name="공연 priceStand", example="15000")
	Integer priceStand;
	@ApiModelProperty(name="공연 priceVip", example="30000")
	Integer priceVip;
	@ApiModelProperty(name="공연 신청한 사람의 ID", example="tkdals2317")
	String ownerId;
	@ApiModelProperty(name="공연 카테고리 이름", example="힙합")
	String categoryName;
}
