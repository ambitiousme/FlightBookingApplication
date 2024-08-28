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

	private Flight flight;

	private Booking booking_id;

	private Passenger passenger_id;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Booking getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Booking booking_id) {
		this.booking_id = booking_id;
	}

	public Passenger getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Passenger passenger_id) {
		this.passenger_id = passenger_id;
	}

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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightSeatDTO [id=" + id + ", seatNumber=" + seatNumber + ", classType=" + classType + ", availability="
				+ availability + ", airline_id=" + airline_id + ", flight=" + flight + ", booking_id="
				+ booking_id + ", passenger_id=" + passenger_id + "]";
	}

}
