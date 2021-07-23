package com.ssafy.api.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 공연 상세 정보 조회 API ([GET] /api/v1/concert/{concertId}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("DetailConcertResponse")
public class ConcertUserDetailRes {
	@ApiModelProperty(name="user_id")
	String userId;
	@ApiModelProperty(name="user_name")
	String userName;
}
