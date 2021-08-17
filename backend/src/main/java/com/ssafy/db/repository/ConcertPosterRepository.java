package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.ConcertPoster;
import com.ssafy.db.entity.ConcertThumbnail;

@Repository
public interface ConcertPosterRepository extends JpaRepository<ConcertPoster, Long>{

}
