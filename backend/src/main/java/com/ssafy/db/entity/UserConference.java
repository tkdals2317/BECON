package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserConference extends BaseEntity {
	@ManyToOne(fetch =FetchType.LAZY)
	Conference conference;
	@ManyToOne(fetch =FetchType.LAZY)
	User user;
	
	public static UserConference of (Conference conference, User user) {
		UserConference userConference = new UserConference();
		userConference.setConference(conference);
		userConference.setUser(user);
		return userConference;	
	}
}
