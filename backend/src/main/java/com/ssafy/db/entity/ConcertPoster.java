package com.ssafy.db.entity;

import javax.persistence.Entity;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConcertPoster extends BaseEntity {
	private String name;
	private String originName;
	private String path;
	
	@Builder
    public ConcertPoster(String name, String originName, String path){
        this.name = name;
        this.originName = originName;
        this.path = path;
    }
}