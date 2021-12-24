package com.flightapp.flightappuserservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	
	private String passengerName;
	
	private int passengerAge;
	
	private String passengerGender;
	
	private String bookieName;
	
	private String bookieEmail;
	
	private String mealSelection;
	
	private String ticketPnr;
	
	private String ticketStatus="PENDING";
	
	private long flightId;

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


	
	
	
}
