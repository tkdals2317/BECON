package com.ssafy.api.service.concert;

import java.util.List;
import java.util.Optional;

import com.ssafy.db.entity.ConcertCategory;

public interface ConcertCategoryService {
	ConcertCategory getCategoryByCategoryId(String name);
	Optional<List<ConcertCategory>> getConcertCategory();
}
