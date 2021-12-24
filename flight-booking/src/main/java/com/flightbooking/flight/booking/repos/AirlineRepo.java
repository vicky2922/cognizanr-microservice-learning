package com.flightbooking.flight.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.flight.booking.models.Airline;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Long> {

	public Airline findByAirlineName(String name);
	
}
