package com.cg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Flight;
import com.cg.fms.exception.FlightNotFoundException;

@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addFlight(Flight flight) {
		
		em.persist(flight);
	}

	@Override
	public List<Flight> viewAllFlight() {
	    String string="select flight from Flight flight";
	    TypedQuery<Flight> query=em.createQuery(string, Flight.class);
	    List<Flight> list=query.getResultList();
	    if(list.isEmpty())
	    	throw new FlightNotFoundException("No Flight Found !");
	    else
		  return list;
	}

	
	@Override
	public void updateFlight(long flightId, Flight flight) {
		
		Flight theFlight=em.find(Flight.class, flightId);
		theFlight.setFlightNumber(flight.getFlightNumber());
		theFlight.setFlightModel(flight.getFlightModel());
		theFlight.setCarrierName(flight.getCarrierName());
		theFlight.setSeatCapacity(flight.getSeatCapacity());
		em.persist(theFlight);
		
		
	}

	@Override
	public void deleteFlight(long flightId) {
		
		Flight flight=em.find(Flight.class, flightId);
		if(flight==null) 
			throw new FlightNotFoundException("No such FlightId found to delete");
		else
			em.remove(flight);
		em.flush();	
		
	}

}
