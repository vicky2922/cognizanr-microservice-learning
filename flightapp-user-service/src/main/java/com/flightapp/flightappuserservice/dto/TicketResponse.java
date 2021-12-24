package com.flightapp.flightappuserservice.dto;

import java.time.LocalDateTime;

public class TicketResponse {
	private long ticketId;

	private String passengerName;

	private int passengerAge;

	private String passengerGender;

	private String bookieName;

	private String bookieEmail;

	private String mealSelection;

	private String ticketPnr = "TICKET";

	private String ticketStatus = "PENDING";

	private long flightId;
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private String fromPort;
	
	private String toPort;
	
	private long price;
	
	private String airlineName;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getBookieName() {
		return bookieName;
	}

	public void setBookieName(String bookieName) {
		this.bookieName = bookieName;
	}

	public String getBookieEmail() {
		return bookieEmail;
	}

	public void setBookieEmail(String bookieEmail) {
		this.bookieEmail = bookieEmail;
	}

	public String getMealSelection() {
		return mealSelection;
	}

	public void setMealSelection(String mealSelection) {
		this.mealSelection = mealSelection;
	}

	public String getTicketPnr() {
		return ticketPnr;
	}

	public void setTicketPnr(String ticketPnr) {
		this.ticketPnr = ticketPnr;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	
}
