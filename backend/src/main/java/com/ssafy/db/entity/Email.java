package com.ssafy.db.entity;

import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Email extends BaseEntity {	
	private String code;
	private String userEmail;
	private String userId;
}