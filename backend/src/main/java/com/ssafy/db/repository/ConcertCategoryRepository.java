package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.User;

@Repository
public interface ConcertCategoryRepository extends JpaRepository<ConcertCategory, Long> {
	Optional<ConcertCategory> findByName(String name);
}
