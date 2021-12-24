package com.flightbooking.flight.booking.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.flight.booking.dto.BookingRequest;
import com.flightbooking.flight.booking.dto.SearchFlightRequest;
import com.flightbooking.flight.booking.models.Booking;
import com.flightbooking.flight.booking.models.Flights;
import com.flightbooking.flight.booking.models.Ticket;
import com.flightbooking.flight.booking.repos.BookingRepo;
import com.flightbooking.flight.booking.repos.FlightsRepo;
import com.flightbooking.flight.booking.repos.TicketRepo;

@Service
public class UserService {
	
	@Autowired
	FlightsRepo flightsRepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	TicketRepo ticketRepo;
	
	public List<Flights> searchFlights(SearchFlightRequest searchFlightReq) {
		List<Flights> allFlights = flightsRepo.findAll();
		List<Flights> filteredFlights = allFlights.stream()
				.filter(e -> e.getFromPort().equals(searchFlightReq.getFromPort())
						&& e.getToPort().equals(searchFlightReq.getToPort())
						&& e.getArrivalTime().isBefore(searchFlightReq.getArrivaDate().plusDays(1).atStartOfDay())
						&& e.getDepartureTime().isAfter(searchFlightReq.getDepartureDate().atStartOfDay()))
				.collect(Collectors.toList());

		return filteredFlights;
	}

	public Booking bookFlight(BookingRequest bookingRequest) {
		Booking booking = new Booking();
		booking.setContactNumber(bookingRequest.getContactNumber());
		booking.setEmailId(bookingRequest.getEmailId());
		Optional<Flights> flight = flightsRepo.findById(bookingRequest.getFlightId());
		if(flight.isPresent() ) {
			booking.setFlights(flight.get());
		}
		booking.setMealSelection(bookingRequest.getMealSelection());
		booking.setNoOfPassangers(bookingRequest.getPassengerDetails().size());
		booking.setBookingStatus("CONFIRMED");
		Booking booked = bookingRepo.save(booking);
		booked.setBookingPnr(booked.getBookingPnr().substring(0,6-String.valueOf(booked.getBookingId()).length() ) + booked.getBookingId());
		this.saveTickets(booked, bookingRequest);
		return bookingRepo.save(booked);
	}

	public void saveTickets(Booking booked, BookingRequest bookingRequest) {
		bookingRequest.getPassengerDetails().forEach(p -> {
			Ticket t = new Ticket();
			t.setName(p.getName());
			t.setAge(p.getAge());
			t.setGender(p.getGender());
			t.setBooking(booked);
			t.setTicketStatus("CONFIRMED");
			Ticket t1 = ticketRepo.save(t);
			t1.setTicketPnr(t1.getTicketPnr().substring(0, 6-String.valueOf(t1.getTicketId()).length()) + t1.getTicketId());
			ticketRepo.save(t1);
		});
	}

}
