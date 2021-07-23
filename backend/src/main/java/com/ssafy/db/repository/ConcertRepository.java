package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

}
