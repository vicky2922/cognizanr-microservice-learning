package com.flightapp.flightappadminservice.dto;

import java.util.List;

public class FlightResponseWrapper {
	
	private List<FlightResponse> flightResult;
	
	public FlightResponseWrapper() {
	}

	public FlightResponseWrapper(List<FlightResponse> flightResult) {
		this.flightResult = flightResult;
	}

	public List<FlightResponse> getFlightResult() {
		return flightResult;
	}

	public void setFlightResult(List<FlightResponse> flightResult) {
		this.flightResult = flightResult;
	}
	

}
