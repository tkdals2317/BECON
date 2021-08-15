package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Email;
import com.ssafy.db.entity.QEmail;

@Repository
public class EmailRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QEmail qEmail = QEmail.email;
	
	public Email findByUserId(String userId) {
		Email result = jpaQueryFactory.selectFrom(qEmail)
				.where(qEmail.userId.eq(userId)).fetchOne();
		if(result==null) {
			return null;
		}
		return result;
	}
	
	public String findCodeByUserId(String userId) {
		String code = jpaQueryFactory.select(qEmail.code).from(qEmail)
				.where(qEmail.userId.eq(userId)).fetchOne();
		return code;
	}
}
