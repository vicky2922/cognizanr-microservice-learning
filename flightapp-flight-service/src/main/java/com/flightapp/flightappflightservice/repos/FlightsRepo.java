package com.flightapp.flightappflightservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.flightappflightservice.models.Flights;


@Repository
public interface FlightsRepo extends JpaRepository<Flights, Long>{

}
