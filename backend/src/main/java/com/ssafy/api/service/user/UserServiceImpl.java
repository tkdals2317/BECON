package com.ssafy.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.UserModifyPostReq;
import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserProfile;
import com.ssafy.db.repository.UserProfileRepository;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.ApiModelProperty;

import java.util.Optional;
/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRepositorySupport userRepositorySupport;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(UserRegisterPostReq request, UserProfile fileId) {
		User user = new User();
		user.setUserId(request.getId());
		// 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		user.setUserProfile(fileId);
		return userRepository.save(user);
	}

	
	@Override
	public Boolean duplicateUserId(String userId) {
		boolean check=true;
		Optional<User> usr = userRepository.findByUserId(userId);
		if(usr.equals(Optional.empty())) {
			check=false;
		}
		return check;
	}
	
	@Override
	public User getUserByUserId(String userId) {
		// 디비에 유저 정보 조회 (userId 를 통한 조회).
		User user = userRepositorySupport.findUserByUserId(userId).get();
		return user;
	}
	
	/*
	 * @Transactional
	 * 
	 * @Override public Long modifyUser(String userId, UserModifyPostReq request) {
	 * //return userRepositorySupport.modifyUserByUserId(userId, request); }
	 */
	
	@Transactional
	@Override
	public Long deleteUser(String userId) {
		// 해당 유저가 생성한 방을 모두 삭제한다.
		// 해당 유저의 지난 회의 이력을 모두 삭제한다.
		// 해당 유저 정보를 삭제한다.
		return userRepositorySupport.deleteUserByUserId(userId);
	}

	@Override
	public Long modifyUser(String userId, UserModifyPostReq request) {
		// TODO Auto-generated method stub
		return null;
	}
}
