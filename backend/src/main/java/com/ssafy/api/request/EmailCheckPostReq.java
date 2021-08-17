package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("EmailCheckPostRequest")
public class EmailCheckPostReq {
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	String userId;
	@ApiModelProperty(name="이메일 Code", example="AXfesf")
	String code;
}
