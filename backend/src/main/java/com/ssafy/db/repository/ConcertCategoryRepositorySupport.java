package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.QConcertCategory;


@Repository
public class ConcertCategoryRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QConcertCategory qConcertCategory = QConcertCategory.concertCategory;

	public Optional<ConcertCategory> findCategoryByCategoryId(String name) {
		ConcertCategory concertCategory = jpaQueryFactory.select(qConcertCategory).from(qConcertCategory).where(qConcertCategory.name.eq(name)).fetchOne();
		if (concertCategory == null)
			return Optional.empty();
		return Optional.ofNullable(concertCategory);
	}

}
