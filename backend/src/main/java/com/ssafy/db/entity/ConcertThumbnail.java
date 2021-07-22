package com.ssafy.db.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ConcertThumbnail extends BaseEntity {
	String name;
	String origin_name;
	String path;
	
	@Builder
    public ConcertThumbnail(String name, String origin_name, String path){
        this.name = name;
        this.origin_name = origin_name;
        this.path = path;
    }
}