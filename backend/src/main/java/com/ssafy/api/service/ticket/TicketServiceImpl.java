package com.ssafy.api.service.ticket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.TicketPostReq;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.Ticket;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.ConcertRepository;
import com.ssafy.db.repository.ConcertRepositorySupport;
import com.ssafy.db.repository.TicketRepository;
import com.ssafy.db.repository.TicketRepositorySupport;

@Service("ticketService")
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	TicketRepositorySupport ticketRepositorySupport;
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	ConcertRepositorySupport concertRepositorySupport;
	
	@Override
	public Ticket buyTicket(TicketPostReq ticketInfo, User user) {
		Ticket ticket=new Ticket();
		Date date=new Date();

		SimpleDateFormat buyDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ticket.setBuyDate(buyDate.format(date));
		ticket.setCode(createCode());
		ticket.setPrice(ticketInfo.getPrice());
		ticket.setType(ticketInfo.getType());
		ticket.setConcert(concertRepositorySupport.findConcertById(ticketInfo.getConcertId()));
		ticket.setUser(user);
		
		return ticketRepository.save(ticket);
	}
	
	@Override
	public String createCode() {
		int size=10;
		if(size > 0) {
			char[] tmp = new char[size];
			for(int i=0; i<tmp.length; i++) {
				int div = (int) Math.floor( Math.random() * 2 );
				if(div == 0)
					tmp[i] = (char) (Math.random() * 10 + '0') ;
				else
					tmp[i] = (char) (Math.random() * 26 + 'A') ;
			}
			return new String(tmp);
		}
		return null;
	}

	@Override
	public Optional<List<Ticket>> findTicketBuy(User user) {
		return ticketRepository.findByUserId(user.getId());
	}
	
}
