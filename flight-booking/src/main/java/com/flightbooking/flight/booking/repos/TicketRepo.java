package com.flightbooking.flight.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.flight.booking.models.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
