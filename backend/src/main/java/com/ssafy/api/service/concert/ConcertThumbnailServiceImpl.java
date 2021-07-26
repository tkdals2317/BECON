package com.ssafy.api.service.concert;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.repository.ConcertThumbnailRepository;

@Service("concertThumbnailService")
public class ConcertThumbnailServiceImpl implements ConcertThumbnailService{
	@Autowired
	ConcertThumbnailRepository concertThumbnailRepository;
	
	@Transactional
	@Override
	public ConcertThumbnail saveFile(ConcertThumbnailPostReq request) {
		return concertThumbnailRepository.save(request.toEntity());
	}

	@Transactional
	@Override
	public ConcertThumbnailPostReq getFile(Long id) {
		ConcertThumbnail concertThumbnail = concertThumbnailRepository.findById(id).get();

		ConcertThumbnailPostReq request = ConcertThumbnailPostReq.builder()
				.originName(concertThumbnail.getOriginName())
				.name(concertThumbnail.getName())
				.path(concertThumbnail.getPath())
				.build();
		return request;
	}
}
