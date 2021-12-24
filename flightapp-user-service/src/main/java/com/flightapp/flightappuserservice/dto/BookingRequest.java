package com.flightapp.flightappuserservice.dto;

import java.util.List;

public class BookingRequest {

	private long flightId;
	private String emailId;
	private String name;
	private String mealSelection;
	private List<PassengerTo> passengerDetails;
	public long getFlightId() {
		return flightId;
	}

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}
	public String getMealSelection() {
		return mealSelection;
	}
	public List<PassengerTo> getPassengerDetails() {
		return passengerDetails;
	}
	
}
