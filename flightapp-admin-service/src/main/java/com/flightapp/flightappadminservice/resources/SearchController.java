package com.flightapp.flightappadminservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.flightappadminservice.dto.FlightResponse;
import com.flightapp.flightappadminservice.dto.FlightResponseWrapper;
import com.flightapp.flightappadminservice.dto.SearchFlightRequest;
import com.flightapp.flightappadminservice.exceptions.FlightNotFoundException;
import com.flightapp.flightappadminservice.services.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("")
	public String testLock() {
		return "unlocked admin api";
	}

	@PostMapping("")
	@ExceptionHandler(value = FlightNotFoundException.class)
	public FlightResponseWrapper searchFlights(@RequestBody SearchFlightRequest searchFlightRequest) throws FlightNotFoundException {
		FlightResponseWrapper frw = new FlightResponseWrapper();
		//fetch blocked airline
		//remove those flights from list of response
		frw.setFlightResult(searchService.searchFlights(searchFlightRequest));
		return frw;
	}
	
	@GetMapping("/{flightId}")
	public FlightResponse searchFlights(@PathVariable long flightId ) {
		return searchService.searchFlightById(flightId);
	}
	
	
}
