package com.ssafy.api.service.concert;

import java.util.Optional;

import com.ssafy.db.entity.ConcertCategory;

public interface ConcertCategoryService {
	ConcertCategory getCategoryByCategoryId(String name);
}
