package com.flightapp.flightappuserservice.services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappuserservice.dto.BookingRequest;
import com.flightapp.flightappuserservice.dto.FlightResponse;
import com.flightapp.flightappuserservice.dto.TicketResponse;
import com.flightapp.flightappuserservice.models.Ticket;
import com.flightapp.flightappuserservice.repos.TicketRepo;

@Service
public class UserService {

	@Autowired
	TicketRepo ticketRepo;

	public List<Ticket> bookFlight(BookingRequest bookingRequest) {

		List<Ticket> ticketList = new ArrayList<>();

		int noOfPassengers = bookingRequest.getPassengerDetails().size();

		for (int i = 0; i < noOfPassengers; i++) {
			Ticket ticket = new Ticket();
			ticket.setFlightId(bookingRequest.getFlightId());
			ticket.setBookieEmail(bookingRequest.getEmailId());
			ticket.setBookieName(bookingRequest.getName());
			ticket.setPassengerName(bookingRequest.getPassengerDetails().get(i).getName());
			ticket.setPassengerAge(bookingRequest.getPassengerDetails().get(i).getAge());
			ticket.setPassengerGender(bookingRequest.getPassengerDetails().get(i).getGender());
			ticket.setMealSelection(bookingRequest.getMealSelection());
			ticket.setTicketStatus("CONFIRMED");
			ticket.setTicketPnr(RandomStringUtils.random(8, true, false));
			ticketList.add(ticketRepo.save(ticket));
		}
		return ticketList;

	}

	public TicketResponse convertIntoTicketResponse(Ticket t, FlightResponse flightResponse) {
		TicketResponse ticketResponse = new TicketResponse();
		ticketResponse.setFlightId(t.getFlightId());
		ticketResponse.setBookieEmail(t.getBookieEmail());
		ticketResponse.setBookieName(t.getBookieName());
		ticketResponse.setPassengerName(t.getPassengerName());
		ticketResponse.setPassengerAge(t.getPassengerAge());
		ticketResponse.setPassengerGender(t.getPassengerGender());
		ticketResponse.setMealSelection(t.getMealSelection());
		ticketResponse.setTicketStatus(t.getTicketStatus());
		ticketResponse.setTicketPnr(t.getTicketPnr());
		ticketResponse.setFromPort(flightResponse.getFromPort());
		ticketResponse.setToPort(flightResponse.getToPort());
		ticketResponse.setDepartureTime(flightResponse.getDepartureTime());
		ticketResponse.setArrivalTime(flightResponse.getArrivalTime());
		ticketResponse.setAirlineName(flightResponse.getAirlineName());
		ticketResponse.setPrice(flightResponse.getPrice());
		ticketResponse.setTicketId(t.getTicketId());
		return ticketResponse;
	}

	public List<Ticket> searchTicketsByEmailId(String emailId) {
		return ticketRepo.findByBookieEmail(emailId);
	}

	public List<Ticket> searchTicketsByPnr(String pnr) {
		return ticketRepo.findByTicketPnr(pnr);
	}

	public Ticket cancleTicketById(long ticketId) {
		Optional<Ticket> ticketOp = ticketRepo.findById(ticketId);
		if(ticketOp.isPresent()) {
			Ticket ticket = ticketOp.get();
			ticket.setTicketStatus("CANCELLED");
			return ticketRepo.save(ticket);
		} 
		return null;
	}

}
