package com.flightbooking.flight.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.flight.booking.dto.NewFlightRequest;
import com.flightbooking.flight.booking.models.Airline;
import com.flightbooking.flight.booking.models.Flights;
import com.flightbooking.flight.booking.repos.AirlineRepo;
import com.flightbooking.flight.booking.repos.FlightsRepo;

@Service
public class FlightService {
	
	@Autowired
	FlightsRepo flightsRepo;
	
	@Autowired
	AirlineRepo airlineRepo;

	public List<Flights> saveFlight(List<NewFlightRequest> flightRequestList) {
		// business logic
		List<Flights> flightList = new ArrayList<>();
		flightRequestList.forEach(flightRequest -> {
			Flights flight = new Flights();
			flight.setDepartureTime(flightRequest.getDepartureTime());
			flight.setArrivalTime(flightRequest.getArrivalTime());
			flight.setFromPort(flightRequest.getFromPort());
			flight.setToPort(flightRequest.getToPort());
			Airline airline = airlineRepo.findByAirlineName(flightRequest.getAirlineName());
			if (null != airline) {
				flight.setAirline(airline);
			}
			flight.setAvailableMeals(flightRequest.getAvailableMeals());
			flight.setPrice(flightRequest.getPrice());
			flight.setTotalCapacity(flightRequest.getTotalCapacity());
			flightList.add(flightsRepo.save(flight));
		});
		return flightList;
	}

	public List<Flights> getFlightDetailsByAirlineName(String airlineName) {
		return flightsRepo.findAll().stream().filter(e -> e.getAirline().getAirlineName().equals(airlineName)).collect(Collectors.toList());
	}

	public List<Flights> getFlightDetails() {
		return flightsRepo.findAll();
	}

}
