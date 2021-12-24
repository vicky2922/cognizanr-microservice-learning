package com.flightapp.flightappuserservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.flightappuserservice.dto.BookingRequest;
import com.flightapp.flightappuserservice.dto.FlightResponse;
import com.flightapp.flightappuserservice.dto.FlightResponseWrapper;
import com.flightapp.flightappuserservice.dto.SearchFlightRequest;
import com.flightapp.flightappuserservice.dto.TicketResponse;
import com.flightapp.flightappuserservice.models.Ticket;
import com.flightapp.flightappuserservice.services.UserService;



@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/searchFlight")
	public List<FlightResponse> searchFlights(@RequestBody SearchFlightRequest searchFlightRequest){
		//return userService.searchFlights(searchFlightRequest);
		FlightResponseWrapper flightResult = restTemplate.postForObject("http://FLIGHTAPP-ADMIN-SERVICE/search", searchFlightRequest, FlightResponseWrapper.class);
		return flightResult.getFlightResult();
	}
	
	@PostMapping("/bookFlight")
	public List<TicketResponse> searchFlights(@RequestBody BookingRequest bookingRequest){
		List<Ticket> ticketList = userService.bookFlight(bookingRequest);
		List<TicketResponse> ticketResponseList = new ArrayList<>();
		for(Ticket t : ticketList) {
			FlightResponse flightResponse = restTemplate
					.getForObject("http://FLIGHTAPP-ADMIN-SERVICE/search/" + t.getFlightId(), FlightResponse.class);
			TicketResponse ticketResponse = userService.convertIntoTicketResponse(t,flightResponse);
			ticketResponseList.add(ticketResponse);
		}
		return ticketResponseList;
	}
	
	@GetMapping("/searchTicketWithEmail/{emailId}")
	public List<TicketResponse> searchTicketsByEmailId(@PathVariable String emailId){
		List<Ticket> ticketList = userService.searchTicketsByEmailId(emailId);
		List<TicketResponse> ticketResponseList = new ArrayList<>();
		for(Ticket t : ticketList) {
			FlightResponse flightResponse = restTemplate
					.getForObject("http://FLIGHTAPP-ADMIN-SERVICE/search/" + t.getFlightId(), FlightResponse.class);
			TicketResponse ticketResponse = userService.convertIntoTicketResponse(t,flightResponse);
			ticketResponseList.add(ticketResponse);
		}
		return ticketResponseList;
	}
	
	@GetMapping("/searchTicketWithPnr/{pnr}")
	public List<TicketResponse> searchTicketsByPnr(@PathVariable String pnr){
		List<Ticket> ticketList = userService.searchTicketsByPnr(pnr);
		List<TicketResponse> ticketResponseList = new ArrayList<>();
		for(Ticket t : ticketList) {
			FlightResponse flightResponse = restTemplate
					.getForObject("http://FLIGHTAPP-ADMIN-SERVICE/search/" + t.getFlightId(), FlightResponse.class);
			TicketResponse ticketResponse = userService.convertIntoTicketResponse(t,flightResponse);
			ticketResponseList.add(ticketResponse);
		}
		return ticketResponseList;
	}
	
	@PutMapping("/cancleTicketById/{ticketId}")
	public TicketResponse cancleTicket(@PathVariable long ticketId) {
		Ticket ticket = userService.cancleTicketById(ticketId);
		if(null!=ticket) {
			FlightResponse flightResponse = restTemplate
					.getForObject("http://FLIGHTAPP-ADMIN-SERVICE/search/" + ticket.getFlightId(), FlightResponse.class);
			TicketResponse ticketResponse = userService.convertIntoTicketResponse(ticket,flightResponse);
			return ticketResponse;
		}
		return null;
	}

}
