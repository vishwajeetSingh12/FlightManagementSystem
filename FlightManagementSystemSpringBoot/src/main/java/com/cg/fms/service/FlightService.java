package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Flight;

public interface FlightService {
	
	public void addFlight(Flight flight);
	
	public List<Flight> viewAllFlight();
	
	public void updateFlight(long flightId, Flight flight);
	
	public void delete(long flightId);
	

}
