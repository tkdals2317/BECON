package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("QnAPostRequest")
public class QnAPostReq {
	@ApiModelProperty(name="유저 email", example="your_email")
	String email;
	@ApiModelProperty(name="유저 Name", example="your_name")
	String name;
	@ApiModelProperty(name="유저 Name", example="your_name")
	String title;
	@ApiModelProperty(name="유저 Name", example="your_name")
	String content;
}
