package com.ssafy.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.db.entity.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
	List<Concert> findByCategoryId(Long category);

	List<Concert> findAll();
	
	List<Concert> findByUserId(Long uesrId);
	
	@Query("SELECT c " + 
			"FROM Concert c " + 
			"WHERE c.isActive in (1, 2) " +
			"ORDER BY c.startTime")
	List<Concert> findComingConcert();
	
	@Query("SELECT c " + 
			"FROM Concert c " + 
			"WHERE TIME_TO_SEC(TIMEDIFF(c.startTime, NOW())) BETWEEN 3540 AND 3600 " +
			"AND c.isActive = 0")
	List<Concert> findComingSoonConcert();
	
	@Transactional
	@Modifying
	@Query("UPDATE Concert c " + 
			"SET c.isActive = 1 " + 
			"WHERE TIME_TO_SEC(TIMEDIFF(c.startTime, NOW())) BETWEEN 0 AND 3600 " +
			"AND c.isActive = 0")
	void updateWaitConcert();
	
	@Transactional
	@Modifying
	@Query("UPDATE Concert c " + 
			"SET c.isActive = 2 " + 
			"WHERE c.startTime < NOW() " +
			"AND c.isActive = 1")
	void updateStartConcert();
	
	@Transactional
	@Modifying
	@Query("UPDATE Concert c " + 
			"SET c.isActive = 3 " + 
			"WHERE c.endTime < NOW() " +
			"AND c.isActive = 2")
	void updateEndConcert();
	
	List<Concert> findByStartTimeBetween(String start, String end);
}
