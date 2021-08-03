package com.ssafy.api.service.ticket;

import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.TicketPostReq;
import com.ssafy.db.entity.Ticket;
import com.ssafy.db.entity.User;

public interface TicketService {
	Ticket buyTicket(TicketPostReq ticketInfo, Long concertId, User user);
	String createCode();
	Optional<List<Ticket>> findTicketBuy(User user);
}
