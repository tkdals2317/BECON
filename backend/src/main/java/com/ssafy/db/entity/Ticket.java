package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket extends BaseEntity {
	@ManyToOne(fetch =FetchType.LAZY)
	private User user;
	@ManyToOne(fetch =FetchType.LAZY)
	private Concert concert;
	
	private String code;
	private String type;
	private Integer price;
	private String buyDate;
	
	public static Ticket of (Concert concert, User user) {
		Ticket ticket = new Ticket();
		ticket.setConcert(concert);
		ticket.setUser(user);
		return ticket;	
	}
}
