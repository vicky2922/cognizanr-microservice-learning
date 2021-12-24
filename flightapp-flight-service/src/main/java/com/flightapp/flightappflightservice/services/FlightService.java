package com.flightapp.flightappflightservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappflightservice.dto.NewFlightRequest;
import com.flightapp.flightappflightservice.dto.SavedFlightResponse;
import com.flightapp.flightappflightservice.models.Flights;
import com.flightapp.flightappflightservice.repos.FlightsRepo;

@Service
public class FlightService {
	
	@Autowired
	FlightsRepo flightsRepo;
	 

	public List<SavedFlightResponse> saveFlight(List<NewFlightRequest> flightRequestList) {
		// business logic
		List<Flights> flightList = new ArrayList<>();

		for (NewFlightRequest flightRequest : flightRequestList) {
			Flights flight = new Flights();
			flight.setDepartureTime(flightRequest.getDepartureTime());
			flight.setArrivalTime(flightRequest.getArrivalTime());
			flight.setFromPort(flightRequest.getFromPort());
			flight.setToPort(flightRequest.getToPort());
			flight.setAvailableMeals(flightRequest.getAvailableMeals());
			flight.setPrice(flightRequest.getPrice());
			flight.setTotalCapacity(flightRequest.getTotalCapacity());
			flight.setAirlineName(flightRequest.getAirlineName());
			flightList.add(flight);
		}
		flightList = flightsRepo.saveAll(flightList);
		
		List<SavedFlightResponse> flightResponseList = new ArrayList<>();
		for (Flights savedFlight : flightList) {
			SavedFlightResponse flight = new SavedFlightResponse();
			flight.setDepartureTime(savedFlight.getDepartureTime());
			flight.setArrivalTime(savedFlight.getArrivalTime());
			flight.setFromPort(savedFlight.getFromPort());
			flight.setToPort(savedFlight.getToPort());
			flight.setAvailableMeals(savedFlight.getAvailableMeals());
			flight.setPrice(savedFlight.getPrice());
			flight.setTotalCapacity(savedFlight.getTotalCapacity());
			flight.setAirlineName(savedFlight.getAirlineName());
			flight.setFlightId(savedFlight.getFlightId());
			flightResponseList.add(flight);
		}
		
		return flightResponseList;
	}

	/*
	 * public List<Flights> getFlightDetailsByAirlineName(String airlineName) {
	 * return flightsRepo.findAll().stream().filter(e ->
	 * e.getAirline().getAirlineName().equals(airlineName)).collect(Collectors.
	 * toList()); }
	 */

	public List<Flights> getFlightDetails() {
		return flightsRepo.findAll();
	}

}
