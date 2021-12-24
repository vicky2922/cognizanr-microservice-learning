package com.flightapp.flightappadminservice.dto;

import java.time.LocalDate;

public class SearchFlightRequest {
	
	private String fromPort;
	private String toPort;
	private LocalDate departureDate;
	private LocalDate arrivaDate;
	private String trip="oneWay";
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
	@Override
	public String toString() {
		return "SearchFlightRequest [fromPort=" + fromPort + ", toPort=" + toPort + ", departureDate=" + departureDate
				+ ", arrivaDate=" + arrivaDate + ", trip=" + trip + "]";
	}
}
