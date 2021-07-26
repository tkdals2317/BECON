package com.ssafy.db.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.db.entity.QUserProfile;

@Repository
public class UserProfileRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QUserProfile qUserProfile = QUserProfile.userProfile;

	public long deleteProfileByProfileId(Long id) {
		long result = jpaQueryFactory.delete(qUserProfile).where(qUserProfile.id.eq(id)).execute();
		return result;
	}

	@Transactional
	public void modifyProfile(Long userPID, UserProfilePostReq userProfile) {
		System.out.println(userPID);
		System.out.println(userProfile.getOriginName());

		jpaQueryFactory.update(qUserProfile)
		.where(qUserProfile.id.eq(userPID))
		.set(qUserProfile.name, userProfile.getName())
		.set(qUserProfile.originName, userProfile.getOriginName())
		.set(qUserProfile.path, userProfile.getPath())
		.execute();
	}

}
