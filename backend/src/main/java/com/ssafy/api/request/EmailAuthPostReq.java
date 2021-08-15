package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("EmailAuthPostRequest")
public class EmailAuthPostReq {
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	String userId;
	@ApiModelProperty(name="유저 email", example="your_email")
	String email;
	@ApiModelProperty(name="유저 Name", example="your_name")
	String name;
}
