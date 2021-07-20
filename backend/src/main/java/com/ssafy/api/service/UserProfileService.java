package com.ssafy.api.service;

import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.db.entity.UserProfile;

public interface UserProfileService {
	Long saveFile(UserProfilePostReq request);
	UserProfilePostReq getFile(Long id);
}
