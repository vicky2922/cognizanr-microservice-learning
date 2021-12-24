package com.flightbooking.flight.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airline")
public class Airline {
	
	@Id
	@GeneratedValue
	private long airlineId;
	private String airlineName;
	private String airlineStatus="unblocked";
	
	public long getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAirlineStatus() {
		return airlineStatus;
	}
	public void setAirlineStatus(String airlineStatus) {
		this.airlineStatus = airlineStatus;
	}
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineStatus=" + airlineStatus
				+ "]";
	}
	
	

}
