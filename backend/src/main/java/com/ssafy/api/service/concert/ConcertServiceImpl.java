package com.ssafy.api.service.concert;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.api.rtc.RoomManager;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserConcert;
import com.ssafy.db.repository.ConcertRepository;
import com.ssafy.db.repository.ConcertRepositorySupport;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService{
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	ConcertRepositorySupport concertRepositorySupport;

	
	@Transactional
	@Override
	public Concert createConcert(ConcertRegisterPostReq request, ConcertThumbnail fileId, User userId, ConcertCategory categoryId) {
		Concert concert = new Concert();
		concert.setTitle(request.getTitle());
		concert.setDescription(request.getDescription());
		concert.setStartTime(request.getStartTime());
		concert.setEndTime(request.getEndTime());
		concert.setPriceStand(request.getPriceStand());
		concert.setPriceVip(request.getPriceVip());
		concert.setIsActive(false);
		concert.setThumbnail(fileId);
		concert.setUser(userId);
		concert.setCategory(categoryId);
		concert.setMinAge(request.getMinAge());
		
		Concert temp = concertRepository.save(concert);
		
		return temp;
	}

	@Override
	public List<Concert> findByCategory(Long category) {
		return concertRepository.findByCategoryId(category);
	}

	@Override
	public List<Concert> findConcerts() {
		return concertRepository.findAll();
	}
	
	@Override
	public List<Concert> findComingConcerts() {
		return concertRepository.findComingConcert();
	}


	@Override
	public Optional<Concert> getConcertByConcertId(Long concertId) {
		return concertRepository.findById(concertId);
	}


	@Override
	public Optional<List<UserConcert>> getUserConcertByConcerId(Long concertId) {
		return concertRepositorySupport.findUserConcertByConcertId(concertId);
	}


	@Override
	public Optional<List<Concert>> getConcertByOwnerId(String ownerId) {
		return concertRepositorySupport.getConcertByOwnerId(ownerId);
	}

	@Transactional
	@Override
	public void deleteConcertByOwnerId(String ownerId) {
		concertRepositorySupport.deleteConcertByOwnerId(ownerId);	
	}
}
