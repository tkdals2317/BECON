package com.ssafy.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Concert extends BaseEntity {
	@OneToOne(fetch =FetchType.LAZY)
	private ConcertThumbnail thumbnail;
	@ManyToOne(fetch =FetchType.LAZY)
	private ConcertCategory category;
	@ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private User user;
	
	private Date start_time;
	private Date end_time;
	private String title;
	private String description;
	private Integer price_vip;
	private Integer price_stand;
	private Boolean is_active;
}
