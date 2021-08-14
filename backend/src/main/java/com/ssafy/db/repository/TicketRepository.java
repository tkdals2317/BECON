package com.ssafy.db.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	Optional<List<Ticket>> findByUserId(Long usreId);
	Optional<List<Ticket>> findByConcertId(Long concertId);
}
