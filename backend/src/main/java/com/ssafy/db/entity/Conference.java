package com.ssafy.db.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conference extends BaseEntity{
	@ManyToOne(fetch =FetchType.LAZY)
	private ConferenceCategory conferenceCategory;
}

