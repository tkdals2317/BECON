package com.ssafy.api.response;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserProfile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 본인 정보 조회 API ([GET] /api/v1/users/me) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserResponse")
public class UserRes{
	@ApiModelProperty(name="User ID")
	String userId;
	@ApiModelProperty(name="User Email")
	String userEmail;
	@ApiModelProperty(name="User Name")
	String userName;
	@ApiModelProperty(name="User Phone")
	String userPhone;
	@ApiModelProperty(name="User Profile")
	UserProfile userProfile;
	public static UserRes of(User user) {
		UserRes res = new UserRes();
		res.setUserId(user.getUserId());
		res.setUserName(user.getName());
		res.setUserEmail(user.getEmail());
		res.setUserPhone(user.getPhone());
		res.setUserProfile(user.getUserProfile());
		return res;
	}
}
