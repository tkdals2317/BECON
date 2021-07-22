package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.request.UserModifyPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class UserRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QUser qUser = QUser.user;

	public Optional<User> findUserByUserId(String userId) {
		User user = jpaQueryFactory.select(qUser).from(qUser).where(qUser.userId.eq(userId)).fetchOne();
		if (user == null)
			return Optional.empty();
		return Optional.ofNullable(user);
	}

	/*
	 * public long modifyUserByUserId(String userId, UserModifyPostReq request) {
	 * 
	 * long result = jpaQueryFactory.update(qUser) .where(qUser.userId.eq(userId))
	 * .set(qUser.name, request.getName()) .set(qUser.mail, request.getMail())
	 * .set(qUser.phone, request.getPhone()) .execute(); return result;
	 * 
	 * }
	 */

	public long deleteUserByUserId(String userId) {
		long result = jpaQueryFactory.delete(qUser).where(qUser.userId.eq(userId)).execute();
		return result;
	}
}
