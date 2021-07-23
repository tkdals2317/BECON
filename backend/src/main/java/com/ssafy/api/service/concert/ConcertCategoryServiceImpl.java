package com.ssafy.api.service.concert;

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
		ConcertCategory category= concertCategoryRepositorySupport.findCategoryByCategoryId(name).get();
		return category;
	}

}
