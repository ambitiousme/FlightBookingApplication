package com.lts.FBA.FlightBookingApplication.DTO;

import com.lts.FBA.FlightBookingApplication.Entity.Booking;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;
import com.lts.FBA.FlightBookingApplication.Entity.Passenger;

public class FlightSeatDTO {

	private Long id;

	private String seatNumber;

	private String classType;

	private Boolean availability;

	private Long airline_id;

	private Flight flight_id;

	private Booking booking_id;

	private Passenger passenger_id;

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Long getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Long airline_id) {
		this.airline_id = airline_id;
	}

	public Flight getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Flight flight_id) {
		this.flight_id = flight_id;
	}

	@Override
	public String toString() {
		return "FlightSeatDTO [id=" + id + ", seatNumber=" + seatNumber + ", classType=" + classType + ", availability="
				+ availability + ", airline_id=" + airline_id + ", flight_id=" + flight_id + ", booking_id="
				+ booking_id + ", passenger_id=" + passenger_id + "]";
	}

}
