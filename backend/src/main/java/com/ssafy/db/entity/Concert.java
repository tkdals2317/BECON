package com.ssafy.db.entity;

import javax.persistence.CascadeType;
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
	@OneToOne(fetch =FetchType.LAZY, cascade=CascadeType.REMOVE, orphanRemoval=true)
	private ConcertThumbnail thumbnail;
	@ManyToOne(fetch =FetchType.LAZY)
	private ConcertCategory category;
	@ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private User user;
	
	private String startTime;
	private String endTime;
	private String title;
	private String description;
	private Integer priceVip;
	private Integer priceStand;
	private Boolean isActive;
}
