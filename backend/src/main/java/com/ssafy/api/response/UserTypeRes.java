package com.ssafy.api.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Ticket;

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
public class UserTypeRes extends BaseResponseBody{
	@ApiModelProperty(name="User type")
	Map<String, String> type;
	
	public static UserTypeRes of(List<Ticket> list) {
		UserTypeRes res = new UserTypeRes();
		Map<String, String> map = new HashMap<>();
		for (Ticket ticket : list) {
			map.put(ticket.getUser().getUserId(), ticket.getType());
		}
		res.setType(map);
		return res;
	}
}
