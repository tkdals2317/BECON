package com.ssafy.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QTicket;

@Repository
public class TicketRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QTicket qTicket = QTicket.ticket;
	
	public long findCountTicket() {
		long result = jpaQueryFactory.selectFrom(qTicket).fetchCount();
		return result;
	}
}
