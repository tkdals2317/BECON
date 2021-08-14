package com.ssafy.api.service.user;

import java.util.Optional;

import com.ssafy.api.request.UserModifyPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserProfile;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserService {
	User createUser(UserRegisterPostReq request, UserProfile fileId);
	Boolean duplicateUserId(String userId);
	User getUserByUserId(String userId);	
	Optional<User> deleteUser(String userId);
	Long modifyUser(String userId, UserModifyPostReq request);
	long getTotalUser();
}
