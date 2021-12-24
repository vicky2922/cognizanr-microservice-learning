package com.flightbooking.flight.booking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.flight.booking.dto.BookingRequest;
import com.flightbooking.flight.booking.dto.SearchFlightRequest;
import com.flightbooking.flight.booking.models.Booking;
import com.flightbooking.flight.booking.models.Flights;
import com.flightbooking.flight.booking.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/search")
	public List<Flights> searchFlights(@RequestBody SearchFlightRequest searchFlightRequest){
		return userService.searchFlights(searchFlightRequest);
	}
	
	@PostMapping("/booking")
	public Booking bookFlights(@RequestBody BookingRequest bookingRequest) {
		return userService.bookFlight(bookingRequest);
	}

}
