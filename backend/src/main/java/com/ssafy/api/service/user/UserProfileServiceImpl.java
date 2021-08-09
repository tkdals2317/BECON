package com.ssafy.api.service.user;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.common.util.MD5Generator;
import com.ssafy.db.entity.UserProfile;
import com.ssafy.db.repository.UserProfileRepository;
import com.ssafy.db.repository.UserProfileRepositorySupport;

@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UserProfileRepositorySupport userProfileRepositorySupport;
	
	@Transactional
	@Override
	public UserProfilePostReq setFile(MultipartFile files) throws NoSuchAlgorithmException, IllegalStateException, IOException {
		UserProfilePostReq userProfileInfo = null;
		String savePath = "/images/profile";
		if(!(files.isEmpty())) {
			String origFilename = files.getOriginalFilename();
	        String filename = new MD5Generator(origFilename).toString();
			String filePath = savePath + "/" + origFilename;
            files.transferTo(new File(filePath));
            
            userProfileInfo=new UserProfilePostReq();
            userProfileInfo.setOriginName(origFilename);
            userProfileInfo.setName(filename);
            userProfileInfo.setPath(filePath);
		}else {
			userProfileInfo=new UserProfilePostReq();
            userProfileInfo.setOriginName("BeConImg.jpg");
            userProfileInfo.setName("5887b47695b084b04d2e575438d5a794");
            userProfileInfo.setPath(savePath+"/BeConImg.jpg");
		}
		
		return userProfileInfo;
	}
	
	@Transactional
	@Override
	public void changeFile(Long userPID, MultipartFile files) throws NoSuchAlgorithmException, IllegalStateException, IOException {
		UserProfilePostReq userProfileInfo=new UserProfilePostReq();
    	System.out.println(userPID);
	
		String origFilename = files.getOriginalFilename();
        String filename = new MD5Generator(origFilename).toString();
		String savePath = "/images/profile";

        String filePath = savePath + "/" + origFilename;
        files.transferTo(new File(filePath));
        userProfileInfo.setOriginName(origFilename);
        userProfileInfo.setName(filename);
        userProfileInfo.setPath(filePath);
        
        userProfileRepositorySupport.modifyProfile(userPID, userProfileInfo);
    }
    
    
    @Transactional
    @Override
    public UserProfile saveFile(UserProfilePostReq request) {
        return userProfileRepository.save(request.toEntity());
    }

}