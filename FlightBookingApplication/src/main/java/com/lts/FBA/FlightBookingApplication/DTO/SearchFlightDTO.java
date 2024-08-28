package com.lts.FBA.FlightBookingApplication.DTO;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;

public class SearchFlightDTO {

	private long id;
	
	private String flightNumber;

	@NotBlank(message = "please enter the source.")
	private String source;

	@NotBlank(message = "please enter the destination.")
	private String destination;

	@NotBlank(message = "please enter the date of the journey.")
	private LocalDate flightDate;

	private double totalDistance;

	private String airlineName;

	private String departureAirportName;

	private String arrivalAirportName;

	private String departureAirportCode;

	private String arrivalAirportCode;

	private LocalDateTime departureTime;

	private LocalDateTime arrivalTime;

	private Duration duration;

	private Double price;

	private int availableSeatCount;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
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

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAvailableSeatCount() {
		return availableSeatCount;
	}

	public void setAvailableSeatCount(int availableSeatCount) {
		this.availableSeatCount = availableSeatCount;
	}

	@Override
	public String toString() {
		return "SearchFlightDTO [flightNumber=" + flightNumber + ", source=" + source + ", destination=" + destination
				+ ", flightDate=" + flightDate + ", totalDistance=" + totalDistance + ", airlineName=" + airlineName
				+ ", departureAirportName=" + departureAirportName + ", arrivalAirportName=" + arrivalAirportName
				+ ", departureAirportCode=" + departureAirportCode + ", arrivalAirportCode=" + arrivalAirportCode
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", duration=" + duration
				+ ", price=" + price + ", availableSeatCount=" + availableSeatCount + "]";
	}

}
