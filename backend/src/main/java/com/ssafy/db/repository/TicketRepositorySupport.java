package com.ssafy.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QTicket;
import com.ssafy.db.entity.Ticket;

@Repository
public class TicketRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QTicket qTicket = QTicket.ticket;
	
	public long findCountTicket() {
		long result = jpaQueryFactory.selectFrom(qTicket).fetchCount();
		return result;
	}
	
	public List<Ticket> findTicketByConcert(Long concertId) {
		List<Ticket> result = jpaQueryFactory.select(qTicket).from(qTicket)
				.where(qTicket.concert.id.eq(concertId)).fetch();
		return result;
	}
	
	public Ticket findConcertBuyTicket(long userId, long concertId, String code) {
		Ticket ticket = jpaQueryFactory.select(qTicket).from(qTicket)
				.where(qTicket.user.id.eq(userId), qTicket.concert.id.eq(concertId), qTicket.code.eq(code))
				.fetchOne();
		return ticket;
	}
}
