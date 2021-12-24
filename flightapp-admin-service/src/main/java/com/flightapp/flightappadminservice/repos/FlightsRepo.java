package com.flightapp.flightappadminservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.flightappadminservice.models.Flights;


@Repository
public interface FlightsRepo extends JpaRepository<Flights, Long>{

}
