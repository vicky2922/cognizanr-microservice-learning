package com.flightbooking.flight.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.flight.booking.models.Airline;
import com.flightbooking.flight.booking.repos.AirlineRepo;

@Service
public class AirlineService {
	
	@Autowired
	AirlineRepo airlineRepo;
	
	public Airline saveAirline(Airline airline) {
		return airlineRepo.save(airline);
	}

	public List<Airline> getAllAirlines() {
		return airlineRepo.findAll();
	}

}
