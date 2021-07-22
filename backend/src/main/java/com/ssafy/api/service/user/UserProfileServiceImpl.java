package com.ssafy.api.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.db.entity.UserProfile;
import com.ssafy.db.repository.UserProfileRepository;

@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;

	@Transactional
	@Override
	public UserProfile saveFile(UserProfilePostReq request) {
		return userProfileRepository.save(request.toEntity());
	}

	@Transactional
	@Override
	public UserProfilePostReq getFile(Long id) {
		UserProfile userProfile = userProfileRepository.findById(id).get();

		UserProfilePostReq request = UserProfilePostReq.builder()
				.originName(userProfile.getOrigin_name())
				.name(userProfile.getName()).path(userProfile.getPath()).build();
		return request;
	}

}
