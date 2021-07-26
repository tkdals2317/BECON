package com.ssafy.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ssafy.db.entity.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
	List<Concert> findByCategoryId(Long category);

	List<Concert> findAll();
	
	List<Concert> findByUserId(Long id);
}
