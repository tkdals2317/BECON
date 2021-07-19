package com.ssafy.db.entity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conference extends BaseEntity{
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="conference_category")
	private ConferenceCategory conferenceCategory;
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private User user;

	
	Date call_start_time;
	Date call_end_time;
	String thumbnail_url;
	String title;
	String description;
	Integer is_acitve;
	
	/*
	 * public static Conference of (ConferenceCategory conferenceCategory, User
	 * user) { Conference conference = new Conference();
	 * conference.setConferenceCategory(conferenceCategory);
	 * conference.setUser(user); return conference; }
	 */
	
}

