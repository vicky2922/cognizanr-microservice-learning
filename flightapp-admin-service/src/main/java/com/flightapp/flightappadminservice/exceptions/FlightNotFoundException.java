package com.flightapp.flightappadminservice.exceptions;

public class FlightNotFoundException extends Exception {

	public FlightNotFoundException() { super(); }
	public FlightNotFoundException(String m) { super(m); }
	public FlightNotFoundException(Exception e) { super(e); }
	public FlightNotFoundException(String m, Exception e) { super(m, e); }
	
}
