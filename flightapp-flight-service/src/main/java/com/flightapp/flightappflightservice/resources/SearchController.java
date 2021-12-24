package com.flightapp.flightappflightservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.flightappflightservice.dto.FlightResponse;
import com.flightapp.flightappflightservice.dto.FlightResponseWrapper;
import com.flightapp.flightappflightservice.dto.SearchFlightRequest;
import com.flightapp.flightappflightservice.services.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@PostMapping("/search")
	public FlightResponseWrapper searchFlights(@RequestBody SearchFlightRequest searchFlightRequest) {
		FlightResponseWrapper frw = new FlightResponseWrapper();
		//fetch blocked airline
		//remove those flights from list of response
		frw.setFlightResult(searchService.searchFlights(searchFlightRequest));
		return frw;
	}
	
	@GetMapping("/search/{flightId}")
	public FlightResponse searchFlights(@PathVariable long flightId ) {
		return searchService.searchFlightById(flightId);
	}

}
