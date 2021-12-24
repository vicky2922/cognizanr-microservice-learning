package com.flightapp.flightappadminservice.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappadminservice.models.Airline;
import com.flightapp.flightappadminservice.repos.AirlineRepo;

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

	public Airline blockAirlineById(long airlineId) {
		Optional<Airline> airlineOp = airlineRepo.findById(airlineId);
		if(airlineOp.isPresent()) {
			Airline airline = airlineOp.get();
			airline.setAirlineStatus("blocked");
			airlineRepo.save(airline);
			return airline;
		}
		return null;
	}

}
