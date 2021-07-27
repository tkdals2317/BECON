package com.ssafy.api.service.concert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.db.entity.ConcertThumbnail;

public interface ConcertThumbnailService {
	ConcertThumbnailPostReq setFile(MultipartFile files) throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalStateException, IOException;
	ConcertThumbnail saveFile(ConcertThumbnailPostReq concertTumbnailInfo);
}
