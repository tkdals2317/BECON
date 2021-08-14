package com.ssafy.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
	List<Concert> findByCategoryId(Long category);

	List<Concert> findAll();
	
	List<Concert> findByUserId(Long uesrId);
	
	@Query("SELECT c " + 
			"FROM Concert c " + 
			"WHERE TIME_TO_SEC(TIMEDIFF(c.startTime, NOW())) BETWEEN -1800 AND 3600 " +
			"ORDER BY c.startTime")
	List<Concert> findComingConcert();
	
	@Query("SELECT c " + 
			"FROM Concert c " + 
			"WHERE TIME_TO_SEC(TIMEDIFF(c.startTime, NOW())) BETWEEN 3540 AND 3600 " +
			"AND c.isActive = 0")
	List<Concert> findComingSoonConcert();
}
