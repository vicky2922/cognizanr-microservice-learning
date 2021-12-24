package com.flightbooking.flight.booking.dto;

import java.util.List;

public class NewFlightRequestWrapper {
	private List<NewFlightRequest> newFlightRequestList ;

	public List<NewFlightRequest> getNewFlightRequestList() {
		return newFlightRequestList;
	}

	public void setNewFlightRequestList(List<NewFlightRequest> newFlightRequestList) {
		this.newFlightRequestList = newFlightRequestList;
	}
	
}
