package com.ssafy.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ConferenceHistory extends BaseEntity {
	@ManyToOne(fetch =FetchType.LAZY)
	Conference conference;
	@ManyToOne(fetch =FetchType.LAZY)
	User user;
	
	Integer action;
	Date inserted_time;
	public static ConferenceHistory of (Conference conference, User user) {
		ConferenceHistory conferenceHistory = new ConferenceHistory();
		conferenceHistory.setConference(conference);
		conferenceHistory.setUser(user);
		return conferenceHistory;
	}
}
