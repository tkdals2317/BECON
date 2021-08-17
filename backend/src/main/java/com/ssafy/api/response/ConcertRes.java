package com.ssafy.api.response;

import java.util.Locale.Category;

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
public class ConcertRes extends BaseResponseBody{
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
	User user;
	@ApiModelProperty(name="공연 카테고리 이름", example="힙합")
	ConcertCategory category;
	@ApiModelProperty(name="공연 연령제한", example="19")
	Integer minAge;
	@ApiModelProperty(name="공연 섬네일 이미지", example="jpg")
	ConcertThumbnail concertThumbnail;
	@ApiModelProperty(name="공연 포스터 이미지", example="jpg")
	ConcertPoster concertposter;
	public static ConcertRes of(Concert concert) {
		ConcertRes res=new ConcertRes();
		res.setTitle(concert.getTitle());
		res.setDescription(concert.getDescription());
		res.setStartTime(concert.getStartTime());
		res.setEndTime(concert.getEndTime());
		res.setPriceVip(concert.getPriceVip());
		res.setPriceStand(concert.getPriceStand());
		res.setUser(concert.getUser());
		res.setCategory(concert.getCategory());
		res.setMinAge(concert.getMinAge());
		res.setConcertThumbnail(concert.getThumbnail());
		res.setConcertposter(concert.getPoster());
		return res;
	}
}

