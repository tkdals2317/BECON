package com.ssafy.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Concert extends BaseEntity {
	@OneToOne(fetch =FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private ConcertThumbnail thumbnail;
	@OneToOne(fetch =FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private ConcertPoster poster;
	@ManyToOne(fetch =FetchType.LAZY, cascade=CascadeType.ALL)
	private ConcertCategory category;
	@ManyToOne(fetch =FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="`owner_id`")
    private User user;
	@OneToMany(mappedBy="concert")
	private List<UserConcert> userConcertLsit=new ArrayList<>();
	
	private String startTime;
	private String endTime;
	private String title;
	private String description;
	private Integer priceVip;
	private Integer priceStand;
	private Integer isActive;
	private Integer minAge;
}
