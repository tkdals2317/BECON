package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel("UserModifyPostRequest")
public class UserModifyPostReq {
	@ApiModelProperty(name="유저 Name", example="your_name")
	String name;
	@ApiModelProperty(name="유저 password", example="your_mail")
	String password;
	@ApiModelProperty(name="유저 email", example="your_email")
	String email;
	@ApiModelProperty(name="유저 phone", example="your_phone")
	String phone;
}
