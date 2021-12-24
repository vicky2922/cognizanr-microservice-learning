package com.flightbooking.flight.booking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.flight.booking.dto.NewFlightRequest;
import com.flightbooking.flight.booking.dto.NewFlightRequestWrapper;
import com.flightbooking.flight.booking.models.Airline;
import com.flightbooking.flight.booking.models.Flights;
import com.flightbooking.flight.booking.services.AirlineService;
import com.flightbooking.flight.booking.services.FlightService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AirlineService airlineService;
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello world!!!";
	}

	/*
	 * Code for airline
	 */
	@GetMapping("/airlines")
	public List<Airline> getAirlines() {
		return airlineService.getAllAirlines();
	}
	
	@PostMapping("/addAirline")
	public Airline addAirline(@RequestBody Airline airline) {
		return airlineService.saveAirline(airline);
	}
	
	/*
	 * Code for flights
	 */
	@PostMapping("/addFlights")
	public List<Flights> addFlights(@RequestBody NewFlightRequestWrapper flightRequestList) {
		return flightService.saveFlight(flightRequestList.getNewFlightRequestList());
	}
	
	@GetMapping("/flights")
	public List<Flights> getFlightsDetails() {
		return flightService.getFlightDetails();
	}
	
	@GetMapping("/flight/{airlineName}")
	public List<Flights> getFlightsDetailsByAirlineName(@PathVariable String airlineName) {
		return flightService.getFlightDetailsByAirlineName(airlineName);
	}


}
