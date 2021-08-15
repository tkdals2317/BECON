package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
