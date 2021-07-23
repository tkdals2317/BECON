package com.ssafy.api.service.concert;

import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.db.entity.ConcertThumbnail;

public interface ConcertThumbnailService {
	ConcertThumbnail saveFile(ConcertThumbnailPostReq concertTumbnailInfo);
	ConcertThumbnailPostReq getFile(Long id);
}
