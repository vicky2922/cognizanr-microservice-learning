package com.flightapp.flightappadminservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flightappadminservice.dto.NewFlightRequest;
import com.flightapp.flightappadminservice.dto.UpdateFlightRequest;
import com.flightapp.flightappadminservice.models.Airline;
import com.flightapp.flightappadminservice.models.Flights;
import com.flightapp.flightappadminservice.repos.AirlineRepo;
import com.flightapp.flightappadminservice.repos.FlightsRepo;

@Service
public class FlightService {
	
	@Autowired
	FlightsRepo flightsRepo;
	
	@Autowired
	AirlineRepo airlineRepo;

	public List<Flights> saveFlight(List<NewFlightRequest> flightRequestList)  {
		// business logic
		List<Flights> flightList = new ArrayList<>();
			flightRequestList.forEach(flightRequest -> {
				Flights flight = new Flights();
				flight.setDepartureTime(flightRequest.getDepartureTime());
				flight.setArrivalTime(flightRequest.getArrivalTime());
				flight.setFromPort(flightRequest.getFromPort());
				flight.setToPort(flightRequest.getToPort());
				Airline airline = airlineRepo.findByAirlineName(flightRequest.getAirlineName());
				if (null != airline) {
					flight.setAirline(airline);
				} 
				flight.setAvailableMeals(flightRequest.getAvailableMeals());
				flight.setPrice(flightRequest.getPrice());
				flight.setTotalCapacity(flightRequest.getTotalCapacity());
				flightList.add(flightsRepo.save(flight));
			});
		
		return flightList;
	}

	public List<Flights> getFlightDetailsByAirlineName(String airlineName) {
		return flightsRepo.findAll().stream().filter(e -> e.getAirline().getAirlineName().equals(airlineName)).collect(Collectors.toList());
	}

	public List<Flights> getFlightDetails() {
		return flightsRepo.findAll();
	}

	public Flights updateFlight(UpdateFlightRequest flightRequest) {
		Optional<Flights> flightOp = flightsRepo.findById(flightRequest.getFlightId());
		if(flightOp.isPresent()) {
			Flights flight = flightOp.get();
			flight.setDepartureTime(flightRequest.getDepartureTime());
			flight.setArrivalTime(flightRequest.getArrivalTime());
			flight.setFromPort(flightRequest.getFromPort());
			flight.setToPort(flightRequest.getToPort());
			Airline airline = airlineRepo.findByAirlineName(flightRequest.getAirlineName());
			if (null != airline) {
				flight.setAirline(airline);
			}
			flight.setAvailableMeals(flightRequest.getAvailableMeals());
			flight.setPrice(flightRequest.getPrice());
			flight.setTotalCapacity(flightRequest.getTotalCapacity());
			return flightsRepo.save(flight);
		}
		return null;
	}

}
