package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@ToString
public class User extends BaseEntity {
	@OneToOne(fetch =FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    private UserProfile userProfile;
	@OneToMany(mappedBy="user", fetch =FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<UserConcert> userConcertLsit=new ArrayList<>();
	
	private String name;
    private String phone;
    private String userId;
    private String email;
    private String carrier;
    
    @ToString.Exclude
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
