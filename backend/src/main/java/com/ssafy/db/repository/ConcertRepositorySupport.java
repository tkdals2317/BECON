package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.QConcert;
import com.ssafy.db.entity.QUserConcert;
import com.ssafy.db.entity.UserConcert;


@Repository
public class ConcertRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QConcert qConcert = QConcert.concert;
	QUserConcert qUserConcert = QUserConcert.userConcert;
	
	public Optional<List<UserConcert>> findUserConcertByConcertId(Long concertId) {
		List<UserConcert> userConcerts = jpaQueryFactory.select(qUserConcert).from(qUserConcert)
				.where(qUserConcert.concert.id.eq(concertId)).fetch();
		return Optional.ofNullable(userConcerts);
	}
	
	public Optional<List<Concert>> getConcertByOwnerId(String ownerId) {
		List<Concert> userConcerts = jpaQueryFactory.select(qConcert).from(qConcert)
				.where(qConcert.user.userId.eq(ownerId)).fetch();
		return Optional.ofNullable(userConcerts);
	}
	
	@Transactional
	public void deleteConcertByOwnerId(String ownerId) {
		System.out.println(ownerId);
		jpaQueryFactory.delete(qConcert)
		.where(qConcert.user.userId.eq(ownerId)).execute();
	}
	
	@Transactional
	public void updateConcertActive(Long concertId, Integer active) {
		jpaQueryFactory.update(qConcert) 
				.where(qConcert.id.eq(concertId))
				.set(qConcert.isActive, active) 
				.execute(); 
	}
	
	public Concert findConcertById(Long Id) {
		Concert concert=jpaQueryFactory.select(qConcert).from(qConcert)
						.where(qConcert.id.eq(Id)).fetchOne();
		return concert;
	}
	
	public long findCountConcert() {
		long result = jpaQueryFactory.selectFrom(qConcert).fetchCount();
		return result;
	}
	
	public long findIngConcert() {
		long result = jpaQueryFactory.selectFrom(qConcert)
						.where(qConcert.isActive.eq(2))
						.fetchCount();
		return result;
	}
}
