package com.cg.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Flight;
import com.cg.fms.exception.FlightNotFoundException;
import com.cg.fms.service.FlightService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/addFlight")
	public ResponseEntity<Object> addFlight(@Valid @RequestBody Flight flight)
	{
		flightService.addFlight(flight);
		return new ResponseEntity<>("You Added Flight Successfully",HttpStatus.OK);
	}

	@GetMapping("/viewAllFlight")
	public ResponseEntity<Object> viewAllFlight()
	{
		return new ResponseEntity<>(flightService.viewAllFlight(),HttpStatus.OK);
	}
	
	
	@PutMapping ("/updateFlight/{flightId}")
	public ResponseEntity<Object> updateFlight(@PathVariable("flightId") long flightId,@RequestBody Flight flight)
	{
	    flightService.updateFlight(flightId, flight);
	    return new ResponseEntity<>("Flight Updated SuccessFully", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<Object> deleteFlight(@PathVariable("flightId") long flightId)
	{
		flightService.delete(flightId);
		return new ResponseEntity<>("Flight Deleted Successfully", HttpStatus.OK);
	}
}
