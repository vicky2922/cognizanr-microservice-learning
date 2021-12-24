package com.flightbooking.flight.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.flight.booking.models.Flights;

@Repository
public interface FlightsRepo extends JpaRepository<Flights, Long>{

}
