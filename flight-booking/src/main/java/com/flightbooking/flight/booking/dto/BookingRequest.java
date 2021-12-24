package com.flightbooking.flight.booking.dto;

import java.util.List;

public class BookingRequest {

	private long flightId;
	private String contactNumber;
	private String emailId;
	private String mealSelection;
	private List<PassengerTo> passengerDetails;
	public long getFlightId() {
		return flightId;
	}
	public String getContactNumber() {
		return contactNumber;
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
