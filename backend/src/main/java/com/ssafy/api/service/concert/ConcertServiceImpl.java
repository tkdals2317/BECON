package com.ssafy.api.service.concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.ConcertRepository;
import com.ssafy.db.repository.ConcertRepositorySupport;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService{
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	ConcertRepositorySupport concertRepositorySupport;
	
	
	@Override
	public Concert createUser(ConcertRegisterPostReq request, ConcertThumbnail fileId, User userId, ConcertCategory categoryId) {
		Concert concert = new Concert();
		concert.setTitle(request.getTitle());
		concert.setDescription(request.getDescription());
		concert.setStartTime(request.getEndTime());
		concert.setEndTime(request.getEndTime());
		concert.setPriceStand(request.getPriceStand());
		concert.setPriceVip(request.getPriceVip());
		concert.setIsActive(false);
		concert.setThumbnail(fileId);
		concert.setUser(userId);
		concert.setCategory(categoryId);
		return concertRepository.save(concert);
	}

}
