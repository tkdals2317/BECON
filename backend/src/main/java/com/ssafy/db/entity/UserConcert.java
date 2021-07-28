package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class UserConcert extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Concert concert;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public static UserConcert of(Concert concert, User user) {
		UserConcert userConcert = new UserConcert();
		userConcert.setConcert(concert);
		userConcert.setUser(user);
		return userConcert;	
	}
}
