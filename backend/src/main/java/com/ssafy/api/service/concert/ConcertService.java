package com.ssafy.api.service.concert;

import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserConcert;

public interface ConcertService {
	Concert createConcert(ConcertRegisterPostReq registerInfo, ConcertPoster posterId, ConcertThumbnail thumbnailId, User userId, ConcertCategory categoryId);
	List<Concert> findByCategory(Long category);
	List<Concert> findConcerts();
	List<Concert> findComingConcerts();
	Optional<Concert> getConcertByConcertId(Long concertId);
	Optional<List<UserConcert>> getUserConcertByConcerId(Long concertId);
	Optional<List<Concert>> getConcertByOwnerId(String ownerId);
	void deleteConcertByOwnerId(String ownerId);
	long getTotalConcert();
	long getIngConcert();
}
