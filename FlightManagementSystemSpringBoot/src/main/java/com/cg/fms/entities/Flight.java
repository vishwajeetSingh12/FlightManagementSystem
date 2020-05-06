package com.cg.fms.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name="Flight")
public class Flight implements Serializable {
	
	@Id
	@NotNull(message="Flight Id is Mandatoty")
	@Column(name="flight_id", length=25)
	long flightId;
	
	
	@Column(name="flight_number", length=25)
	String flightNumber;
	
	
	@Column(name="flight_model", length=25)
	String flightModel;
	
	
	@Column(name="carrier_name", length=25)
	String carrierName;
	
	
	@Column(name="seat_capacity", length=25)
	String seatCapacity;
	
	public Flight() {}
	
	public Flight(long flightId, String flightNumber, String flightModel,String carrierName, String seatCapacity) {
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	
	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	
	
	
	

}
