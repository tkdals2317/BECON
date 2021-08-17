package com.ssafy.api.service.concert;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserConcert;
import com.ssafy.db.repository.ConcertRepository;
import com.ssafy.db.repository.ConcertRepositorySupport;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	ConcertRepositorySupport concertRepositorySupport;

	@Transactional
	@Override
	public Concert createConcert(ConcertRegisterPostReq request, ConcertPoster posterId, ConcertThumbnail thumbnailId, User userId,
			ConcertCategory categoryId) {
		Concert concert = new Concert();
		concert.setTitle(request.getTitle());
		concert.setDescription(request.getDescription());
		concert.setStartTime(request.getStartTime());
		concert.setEndTime(request.getEndTime());
		concert.setPriceStand(request.getPriceStand());
		concert.setPriceVip(request.getPriceVip());
		concert.setIsActive(0);
		concert.setPoster(posterId);
		concert.setThumbnail(thumbnailId);
		concert.setUser(userId);
		concert.setCategory(categoryId);
		concert.setMinAge(request.getMinAge());
		System.out.println(concert.getPoster().getOriginName());
		Concert temp = concertRepository.save(concert);

		return temp;
	}

	@Override
	public List<Concert> findByCategory(Long category) {
		List<Concert> concert=concertRepository.findByCategoryId(category);
		return concert;
	}

	@Override
	public List<Concert> findConcerts() {
		return concertRepository.findAll(Sort.by(Sort.Direction.ASC, "startTime"));
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
	
	@Override
	public long getTotalConcert() {
		long total = concertRepositorySupport.findCountConcert();
		return total;
	}
	
	@Override
	public long getIngConcert() {
		long total = concertRepositorySupport.findIngConcert();
		return total;
	}
}
