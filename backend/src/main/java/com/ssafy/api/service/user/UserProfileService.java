package com.ssafy.api.service.user;

import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.db.entity.UserProfile;

public interface UserProfileService {
	UserProfile saveFile(UserProfilePostReq request);
	UserProfilePostReq getFile(Long id);
}
