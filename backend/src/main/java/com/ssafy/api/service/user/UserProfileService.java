package com.ssafy.api.service.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.db.entity.UserProfile;

public interface UserProfileService {
	UserProfilePostReq setFile(MultipartFile files, String userId) throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalStateException, IOException;
	UserProfile saveFile(UserProfilePostReq request);
	void changeFile(Long userPID, String userId, MultipartFile files) throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalStateException, IOException;
	
}
