package com.flightbooking.flight.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;

	private String emailId;
	private String contactNumber;
	private String bookingStatus="PENDING";
	
	@ManyToOne
	@JoinColumn(name="flight_id", nullable = false)
	private Flights flights;
	
	private String mealSelection;
	
	private int noOfPassangers;
	
	private String bookingPnr="ABCDEF";

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Flights getFlights() {
		return flights;
	}

	public void setFlights(Flights flights) {
		this.flights = flights;
	}

	public String getMealSelection() {
		return mealSelection;
	}

	public void setMealSelection(String mealSelection) {
		this.mealSelection = mealSelection;
	}

	public String getBookingPnr() {
		return bookingPnr;
	}

	public void setBookingPnr(String bookingPnr) {
		this.bookingPnr = bookingPnr;
	}

	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	
	
}
