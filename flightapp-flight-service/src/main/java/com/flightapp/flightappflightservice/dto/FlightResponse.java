package com.flightapp.flightappflightservice.dto;

import java.time.LocalDateTime;


public class FlightResponse {
	
	private long flightId;
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private String fromPort;
	
	private String toPort;
	
	private long price;
	
	private String airlineName;
	
	private String availableMeals;
	
	private int totalCapacity;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", fromPort=" + fromPort + ", toPort=" + toPort + ", price=" + price + ", airlineName=" + airlineName
				+ ", availableMeals=" + availableMeals + ", totalCapacity=" + totalCapacity + "]";
	}




	
	
	

}
