package com.ssafy.db.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ConcertThumbnail extends BaseEntity {
	String name;
	String origin_name;
	String path;
}