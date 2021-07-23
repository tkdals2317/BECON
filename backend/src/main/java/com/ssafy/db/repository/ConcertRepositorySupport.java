package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.QConcert;


@Repository
public class ConcertRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QConcert qConcert = QConcert.concert;
	
	
//	public Optional<Concert> findConcertByUserId(String category) {		
//		Concert concert = jpaQueryFactory.select(qUser).from(qUser).where(qUser.userId.eq(userId)).fetchOne();
//		if (user == null)
//			return Optional.empty();
//		return Optional.ofNullable(user);
//	}
	
}
