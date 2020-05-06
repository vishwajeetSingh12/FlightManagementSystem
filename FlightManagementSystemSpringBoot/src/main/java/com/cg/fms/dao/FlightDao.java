package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.entities.Flight;

public interface FlightDao {

	public void addFlight(Flight flight);
	public List<Flight> viewAllFlight();
	public void updateFlight(long flightId, Flight flight);
	public void deleteFlight(long flightId);
}
