package com.flightapp.flightappflightservice.dto;

import java.time.LocalDate;

public class SearchFlightRequest {
	
	private String fromPort;
	private String toPort;
	private LocalDate departureDate;
	private LocalDate arrivaDate;
	private String trip;
	public String getFromPort() {
		return fromPort;
	}
	public String getToPort() {
		return toPort;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public LocalDate getArrivaDate() {
		return arrivaDate;
	}
	public String getTrip() {
		return trip;
	}
}
