package com.ssafy.api.response;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@ApiModel("ConcertConfirmRequest")
public class ConcertShowRes extends BaseResponseBody{
	@ApiModelProperty(name="공연 title", example="프리스타일 힙합 쇼")
	Concert concert;
	@ApiModelProperty(name="공연 description", example="프리스타일로 힙합 공연을 해보자")
	Boolean isShow;
	
	public static ConcertShowRes of(Concert concert) {
		ConcertShowRes res=new ConcertShowRes();
		res.setConcert(concert);
		res.setIsShow(false);
		return res;
	}
}

