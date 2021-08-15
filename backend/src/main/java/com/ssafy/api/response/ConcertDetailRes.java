package com.ssafy.api.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.UserConcert;
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
public class ConcertDetailRes{
	@ApiModelProperty(name="ID")
	Long id;
	@ApiModelProperty(name="Category")
	String category;
	@ApiModelProperty(name="Owner Name")
	String owner;
	@ApiModelProperty(name="StartTime")
	String startTime;
	@ApiModelProperty(name="EndTime")
	String endTime;
	@ApiModelProperty(name="Thumbnail")
	ConcertThumbnail thumbnail;
	@ApiModelProperty(name="Title")
	String title;
	@ApiModelProperty(name="PriceStand")
	Integer priceStand;
	@ApiModelProperty(name="PriceVip")
	Integer priceVip;
	@ApiModelProperty(name="Decription")
	String decription;
	@ApiModelProperty(name="IsActive")
	Integer isActive;
	@ApiModelProperty(name="IsMinAge")
	Integer minAge;
	@ApiModelProperty(name="Users")
	List<ConcertUserDetailRes> users;

	public static ConcertDetailRes of(Optional<Concert> concert, Optional<List<UserConcert>> userConcerts) {
		ConcertDetailRes res = new ConcertDetailRes();
		List<ConcertUserDetailRes> userResList = getUserRes(userConcerts);
		res.setId(concert.get().getId());
		res.setCategory(concert.get().getCategory().getName());
		res.setOwner(concert.get().getUser().getName());
		res.setStartTime(concert.get().getStartTime());
		res.setEndTime(concert.get().getEndTime());
		res.setThumbnail(concert.get().getThumbnail());
		res.setTitle(concert.get().getTitle());
		res.setPriceStand(concert.get().getPriceStand());
		res.setPriceVip(concert.get().getPriceVip());
		res.setDecription(concert.get().getDescription());
		res.setIsActive(concert.get().getIsActive());
		res.setMinAge(concert.get().getMinAge());
		res.setUsers(userResList);
		return res;
	}

	private static List<ConcertUserDetailRes> getUserRes(Optional<List<UserConcert>> userConcerts) {		
		List<ConcertUserDetailRes> res = new ArrayList<ConcertUserDetailRes>();
		for(UserConcert uc : userConcerts.get()) {
			ConcertUserDetailRes user = new ConcertUserDetailRes();
			user.setUserId(uc.getUser().getUserId());
			user.setUserName(uc.getUser().getName());
			res.add(user);
		}
		return res;
	}
}
