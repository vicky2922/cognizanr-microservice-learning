package com.flightapp.flightappadminservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.flightappadminservice.dto.NewFlightRequestWrapper;
import com.flightapp.flightappadminservice.dto.UpdateFlightRequest;
import com.flightapp.flightappadminservice.models.Airline;
import com.flightapp.flightappadminservice.models.Flights;
import com.flightapp.flightappadminservice.services.AirlineService;
import com.flightapp.flightappadminservice.services.FlightService;


@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	AirlineService airlineService;
	
	
	  @Autowired 
	  FlightService flightService;
	 
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("")
	public String testLock() {
		return "Locked admin api";
	}
	
	@PostMapping("/addAirline")
	public Airline addAirline(@RequestBody Airline airline) {
		return airlineService.saveAirline(airline);
	}
	
	@PostMapping("/addFlights")
	public List<Flights> addFlights(@RequestBody NewFlightRequestWrapper flightRequestList) {
		
		//SavedFlightResponseWrapper flightResult = restTemplate.postForObject("http://FlightApp-Flight-Service/addFlights", flightRequestList, SavedFlightResponseWrapper.class);
		
			return flightService.saveFlight(flightRequestList.getNewFlightRequestList());
			// TODO Auto-generated catch block
		//return flightResult.getSavedFlightResponseList();
	}
	
	@PutMapping("/blockAirline/{airlineId}")
	public Airline blockAirlineById(@PathVariable long airlineId) {
		return airlineService.blockAirlineById(airlineId);
	}
	
	@PutMapping("/updateFlight")
	public Flights updateFlight(@RequestBody UpdateFlightRequest updateFlightRequest) {
		return flightService.updateFlight(updateFlightRequest);
	}

}
