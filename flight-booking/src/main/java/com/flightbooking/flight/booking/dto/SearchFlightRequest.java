package com.flightbooking.flight.booking.dto;

import java.time.LocalDate;

public class SearchFlightRequest {
	
	private String fromPort;
	private String toPort;
	private LocalDate departureDate;
	private LocalDate arrivaDate;
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
}
