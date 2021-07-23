package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.QConcert;
import com.ssafy.db.entity.User;


@Repository
public class ConcertRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QConcert qConcert = QConcert.concert;
	
//	public Optional<User> findConcertByUserId(Long userId) {
//		User user = jpaQueryFactory.select(qConcert).from(qConcert).where(qConcert.eq(userId)).fetchOne();
//		if (user == null)
//			return Optional.empty();
//		return Optional.ofNullable(user);
//	}
	
}
