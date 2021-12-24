package com.flightapp.flightappflightservice.dto;

import java.util.List;

public class SavedFlightResponseWrapper {
	
	private List<SavedFlightResponse> savedFlightResponseList;

	public List<SavedFlightResponse> getSavedFlightResponseList() {
		return savedFlightResponseList;
	}

	public void setSavedFlightResponseList(List<SavedFlightResponse> savedFlightResponseList) {
		this.savedFlightResponseList = savedFlightResponseList;
	}


	public SavedFlightResponseWrapper() {
	}
	
	public SavedFlightResponseWrapper(List<SavedFlightResponse> savedFlightResponseList) {
		this.savedFlightResponseList = savedFlightResponseList;
	}


}
