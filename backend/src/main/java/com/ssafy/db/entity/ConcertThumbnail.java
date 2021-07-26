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
	String originName;
	String path;
	
	@Builder
    public ConcertThumbnail(String name, String originName, String path){
        this.name = name;
        this.originName = originName;
        this.path = path;
    }
}