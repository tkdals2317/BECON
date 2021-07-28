package com.ssafy.db.entity;

import javax.persistence.Entity;
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
	String originName;
	String path;
	
	@Builder
    public UserProfile(String name, String originName, String path){
        this.name = name;
        this.originName = originName;
        this.path = path;
    }
}
