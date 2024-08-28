package com.lts.FBA.FlightBookingApplication.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FlightSeats")
public class FlightSeat {

	@Id
	private Long id;

	@Column(nullable = false)
	private String seatNumber;

	@Column(nullable = false)
	private String classType;

	@Column(nullable = false)
	private Boolean availability;

	@Column(nullable = false)
	private Long airline_id;

	@ManyToOne
	@JoinColumn(name = "flight_id", nullable = false)
	@JsonBackReference(value="Flight-FlightSeats")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "booking_id",nullable = true)
	private Booking booking;

	@OneToOne
	@JoinColumn(name = "passenger_id",nullable = true)
	private Passenger passenger;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime creationTm;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime lastUpdateTm;

	public LocalDateTime getCreationTm() {
		return creationTm;
	}

	public void setCreationTm(LocalDateTime creationTm) {
		this.creationTm = creationTm;
	}

	public LocalDateTime getLastUpdateTm() {
		return lastUpdateTm;
	}

	public void setLastUpdateTm(LocalDateTime lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}