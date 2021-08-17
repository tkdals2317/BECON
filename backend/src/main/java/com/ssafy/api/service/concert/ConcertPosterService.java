package com.ssafy.api.service.concert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ConcertPosterPostReq;
import com.ssafy.db.entity.ConcertPoster;

public interface ConcertPosterService {
	ConcertPosterPostReq setFile(MultipartFile files) throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalStateException, IOException;
	ConcertPoster saveFile(ConcertPosterPostReq concertTumbnailInfo);
}
