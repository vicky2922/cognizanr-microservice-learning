package com.flightbooking.flight.booking.dto;

import java.time.LocalDateTime;

public class NewFlightRequest {
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private String fromPort;

	private String toPort;
	
	private long price;
	
	private String airlineName;
	
	private String availableMeals;
	
	private int totalCapacity;

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFromPort() {
		return fromPort;
	}

	public void setFromPort(String fromPort) {
		this.fromPort = fromPort;
	}

	public String getToPort() {
		return toPort;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAvailableMeals() {
		return availableMeals;
	}

	public void setAvailableMeals(String availableMeals) {
		this.availableMeals = availableMeals;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	


}
