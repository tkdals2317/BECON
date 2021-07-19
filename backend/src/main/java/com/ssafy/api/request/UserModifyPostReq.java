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
	@ApiModelProperty(name="유저 Department", example="your_department")
	String department;
	@ApiModelProperty(name="유저 Position", example="your_position")
	String position;
}
