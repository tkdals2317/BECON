package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserProfile extends BaseEntity{
	String name;
	String origin_name;
	String path;
	
	@Builder
    public UserProfile(String name, String origin_name, String path){
        this.name = name;
        this.origin_name = origin_name;
        this.path = path;
    }
}
