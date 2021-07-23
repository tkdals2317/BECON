package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.User;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
	Optional<List<Concert>> findByCategoryId(Long category);
}
