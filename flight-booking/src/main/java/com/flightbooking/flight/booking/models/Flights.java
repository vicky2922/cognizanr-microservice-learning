package com.flightbooking.flight.booking.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="flights")
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flightId;
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private String fromPort;
	
	private String toPort;
	
	private long price;
	
	@ManyToOne
	@JoinColumn(name="airline_id", nullable = false)
	private Airline airline;
	
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

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
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

	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", fromPort=" + fromPort + ", toPort=" + toPort + ", price=" + price + ", airline=" + airline
				+ ", availableMeals=" + availableMeals + ", totalCapacity=" + totalCapacity + "]";
	}



	
	
	

}
