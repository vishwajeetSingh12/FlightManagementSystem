package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.FlightDao;
import com.cg.fms.entities.Flight;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;
	
	@Override
	public void addFlight(Flight flight) {
		
		flightDao.addFlight(flight);
		
	}

	@Override
	public List<Flight> viewAllFlight() {
		
		return flightDao.viewAllFlight();
	}


	@Override
	public void updateFlight(long flightId, Flight flight) {
		
		flightDao.updateFlight(flightId, flight);
		
	}

	@Override
	public void delete(long flightId) {
		
		flightDao.deleteFlight(flightId);
		
	}

}
