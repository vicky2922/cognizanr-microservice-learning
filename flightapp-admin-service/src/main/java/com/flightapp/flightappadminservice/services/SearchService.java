package com.flightapp.flightappadminservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappadminservice.dto.FlightResponse;
import com.flightapp.flightappadminservice.dto.SearchFlightRequest;
import com.flightapp.flightappadminservice.exceptions.FlightNotFoundException;
import com.flightapp.flightappadminservice.models.Flights;
import com.flightapp.flightappadminservice.repos.FlightsRepo;


@Service
public class SearchService {
	
	@Autowired
	FlightsRepo flightsRepo;

	public List<FlightResponse> searchFlights(SearchFlightRequest searchFlightReq) throws FlightNotFoundException {
		List<Flights> allFlights = flightsRepo.findAll();
		List<Flights> filteredFlights = new ArrayList<>();
		if (searchFlightReq.getTrip().equalsIgnoreCase("oneWay")) {
			filteredFlights = allFlights.stream()
					.filter(e -> e.getFromPort().equals(searchFlightReq.getFromPort())
							&& e.getToPort().equals(searchFlightReq.getToPort())
							&& e.getArrivalTime().isBefore(searchFlightReq.getArrivaDate().plusDays(1).atStartOfDay())
							&& e.getDepartureTime().isAfter(searchFlightReq.getDepartureDate().atStartOfDay()) 
							&& e.getAirline().getAirlineStatus().equals("unblocked"))
					.collect(Collectors.toList());
		} else if (searchFlightReq.getTrip().equalsIgnoreCase("roundTrip")) {
			filteredFlights = allFlights.stream()
					.filter(e -> ((e.getFromPort().equals(searchFlightReq.getFromPort())
							&& e.getToPort().equals(searchFlightReq.getToPort()))
							|| (e.getFromPort().equals(searchFlightReq.getToPort())
									&& e.getToPort().equals(searchFlightReq.getFromPort())))
							&& e.getArrivalTime().isBefore(searchFlightReq.getArrivaDate().plusDays(1).atStartOfDay())
							&& e.getDepartureTime().isAfter(searchFlightReq.getDepartureDate().atStartOfDay())
							&& e.getAirline().getAirlineStatus().equals("unblocked"))
					.collect(Collectors.toList());
		}

		List<FlightResponse> flightResponseList = new ArrayList<>();
		filteredFlights.forEach(f -> {
			FlightResponse fr = convertIntoFlightResponse(f);
			flightResponseList.add(fr);
		});
		if(!flightResponseList.isEmpty()) {
			return flightResponseList;
		} else {
			throw new FlightNotFoundException("Flights not available for given request :"+ searchFlightReq.toString());
		}
		
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
		fr.setAirlineName(f.getAirline().getAirlineName());
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
