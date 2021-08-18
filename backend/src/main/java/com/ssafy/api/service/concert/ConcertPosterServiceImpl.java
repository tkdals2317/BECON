package com.ssafy.api.service.concert;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ConcertPosterPostReq;
import com.ssafy.common.util.MD5Generator;
import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.repository.ConcertPosterRepository;

@Service("concertPosterService")
public class ConcertPosterServiceImpl implements ConcertPosterService {
	@Autowired
	ConcertPosterRepository concertPosterRepository;

	@Transactional
	@Override
	public ConcertPoster saveFile(ConcertPosterPostReq request) {
		return concertPosterRepository.save(request.toEntity());
	}

	@Override
	public ConcertPosterPostReq setFile(MultipartFile files)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalStateException, IOException {
		ConcertPosterPostReq concertPosterInfo = null;
		String origFilename = files.getOriginalFilename();
		String filename = new MD5Generator(origFilename).toString();
		
		String savePath = "/images/poster";
		
		String filePath = savePath + "/" + origFilename;
		files.transferTo(new File(filePath));
		
		concertPosterInfo = new ConcertPosterPostReq();
		concertPosterInfo.setOriginName(origFilename);  
		concertPosterInfo.setName(filename);
		concertPosterInfo.setPath(filePath);

		return concertPosterInfo;
	}
}
