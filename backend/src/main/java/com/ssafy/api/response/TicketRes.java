package com.ssafy.api.response;

import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.Ticket;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TicketResponse")
public class TicketRes {	
	@ApiModelProperty(name="Buy Date")
	String buyDate;
	@ApiModelProperty(name="Ticket Code")
	String code;
	@ApiModelProperty(name="Ticket Price")
	int price;
	@ApiModelProperty(name="Ticket Type")
	String type;
	@ApiModelProperty(name="Concert Information")
	Concert concert;
	
	public static TicketRes of(Ticket ticket) {
		TicketRes res=new TicketRes();
		res.setBuyDate(ticket.getBuyDate());
		res.setCode(ticket.getCode());
		res.setPrice(ticket.getPrice());
		res.setType(ticket.getType());
		res.setConcert(ticket.getConcert());
		return res;
	}
}


