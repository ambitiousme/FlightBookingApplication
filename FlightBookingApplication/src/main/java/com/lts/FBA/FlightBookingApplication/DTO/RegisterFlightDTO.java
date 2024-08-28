package com.lts.FBA.FlightBookingApplication.DTO;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.lts.FBA.FlightBookingApplication.Entity.Airline;
import com.lts.FBA.FlightBookingApplication.Entity.Airport;

public class RegisterFlightDTO {

	private long id;

	@NotBlank(message = "please enter the source.")
	private String source;

	@NotBlank(message = "please enter the destination.")
	private String destination;

	@NotBlank(message = "please enter the Departure Time.")
	private LocalDateTime departureTime;

	@NotBlank(message = "please enter the Expected Arrival time.")
	private LocalDateTime arrivalTime;

	@NotBlank(message = "please set the price.")
	private Double price;

	@NotNull(message = "please select one Airline.")
	private Airline airline;

	@NotNull(message = "please select departure Airport.")
	private Airport departureAirport;

	@NotNull(message = "please select arrival Airport.")
	private Airport arrivalAirport;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@Override
	public String toString() {
		return "RegisterFlightDTO [id=" + id + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price
				+ ", airline=" + airline + ", departureAirport=" + departureAirport + ", arrivalAirport="
				+ arrivalAirport + "]";
	}

}
