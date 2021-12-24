package com.flightapp.flightappadminservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.flightappadminservice.models.Airline;


@Repository
public interface AirlineRepo extends JpaRepository<Airline, Long> {

	public Airline findByAirlineName(String name);
	
}
