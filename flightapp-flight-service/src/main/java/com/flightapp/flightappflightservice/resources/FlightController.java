package com.flightapp.flightappflightservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.flightappflightservice.dto.NewFlightRequestWrapper;
import com.flightapp.flightappflightservice.dto.SavedFlightResponseWrapper;
import com.flightapp.flightappflightservice.services.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/addFlights")
	public SavedFlightResponseWrapper addFlights(@RequestBody NewFlightRequestWrapper flightRequestWrapper) {
		SavedFlightResponseWrapper savedFlights = new SavedFlightResponseWrapper();
		savedFlights.setSavedFlightResponseList(flightService.saveFlight(flightRequestWrapper.getNewFlightRequestList()));
		return savedFlights;
	}
}
