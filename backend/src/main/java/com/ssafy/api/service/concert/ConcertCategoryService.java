package com.ssafy.api.service.concert;

import com.ssafy.db.entity.ConcertCategory;

public interface ConcertCategoryService {
	ConcertCategory getCategoryByCategoryId(String name);
}
