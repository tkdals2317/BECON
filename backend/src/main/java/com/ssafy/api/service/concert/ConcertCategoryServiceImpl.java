package com.ssafy.api.service.concert;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.repository.ConcertCategoryRepository;
import com.ssafy.db.repository.ConcertCategoryRepositorySupport;

@Service("concertCategoryService")
public class ConcertCategoryServiceImpl implements ConcertCategoryService{
	@Autowired
	ConcertCategoryRepository concertCategoryRepository;
	@Autowired
	ConcertCategoryRepositorySupport concertCategoryRepositorySupport;
	
	@Override
	public ConcertCategory getCategoryByCategoryId(String name) {
		Optional<ConcertCategory> category= concertCategoryRepositorySupport.findCategoryByCategoryId(name);
		return category.get();
	}

	@Override
	public Optional<List<ConcertCategory>> getConcertCategory() {
		return Optional.ofNullable(concertCategoryRepository.findAll());
	}

}
