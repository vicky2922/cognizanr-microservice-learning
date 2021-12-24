package com.flightapp.flightappflightservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappflightservice.dto.FlightResponse;
import com.flightapp.flightappflightservice.dto.SearchFlightRequest;
import com.flightapp.flightappflightservice.models.Flights;
import com.flightapp.flightappflightservice.repos.FlightsRepo;

@Service
public class SearchService {

	@Autowired
	FlightsRepo flightsRepo;

	public List<FlightResponse> searchFlights(SearchFlightRequest searchFlightReq) {
		List<Flights> allFlights = flightsRepo.findAll();
		List<Flights> filteredFlights = new ArrayList<>();
		if (searchFlightReq.getTrip().equalsIgnoreCase("oneWay")) {
			filteredFlights = allFlights.stream()
					.filter(e -> e.getFromPort().equals(searchFlightReq.getFromPort())
							&& e.getToPort().equals(searchFlightReq.getToPort())
							&& e.getArrivalTime().isBefore(searchFlightReq.getArrivaDate().plusDays(1).atStartOfDay())
							&& e.getDepartureTime().isAfter(searchFlightReq.getDepartureDate().atStartOfDay()))
					.collect(Collectors.toList());
		} else if (searchFlightReq.getTrip().equalsIgnoreCase("roundTrip")) {
			filteredFlights = allFlights.stream()
					.filter(e -> ((e.getFromPort().equals(searchFlightReq.getFromPort())
							&& e.getToPort().equals(searchFlightReq.getToPort()))
							|| (e.getFromPort().equals(searchFlightReq.getToPort())
									&& e.getToPort().equals(searchFlightReq.getFromPort())))
							&& e.getArrivalTime().isBefore(searchFlightReq.getArrivaDate().plusDays(1).atStartOfDay())
							&& e.getDepartureTime().isAfter(searchFlightReq.getDepartureDate().atStartOfDay()))
					.collect(Collectors.toList());
		}

		List<FlightResponse> flightResponseList = new ArrayList<>();
		filteredFlights.forEach(f -> {
			FlightResponse fr = convertIntoFlightResponse(f);
			flightResponseList.add(fr);
		});
		return flightResponseList;
	}

	public FlightResponse searchFlightById(long flightId) {
		Optional<Flights> flight = flightsRepo.findById(flightId);
		if (flight.isPresent()) {
			return convertIntoFlightResponse(flight.get());
		}
		return null;
	}

	public FlightResponse convertIntoFlightResponse(Flights f) {
		FlightResponse fr = new FlightResponse();
		fr.setAirlineName(f.getAirlineName());
		fr.setDepartureTime(f.getDepartureTime());
		fr.setPrice(f.getPrice());
		fr.setArrivalTime(f.getArrivalTime());
		fr.setAvailableMeals(f.getAvailableMeals());
		fr.setFromPort(f.getFromPort());
		fr.setToPort(f.getToPort());
		fr.setTotalCapacity(f.getTotalCapacity());
		fr.setFlightId(f.getFlightId());

		return fr;
	}
}
