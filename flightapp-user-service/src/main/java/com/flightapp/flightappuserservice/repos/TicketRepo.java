package com.flightapp.flightappuserservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.flightappuserservice.models.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>{

	public List<Ticket> findByBookieEmail(String emailId);
	
	public List<Ticket> findByTicketPnr(String emailId);
}
