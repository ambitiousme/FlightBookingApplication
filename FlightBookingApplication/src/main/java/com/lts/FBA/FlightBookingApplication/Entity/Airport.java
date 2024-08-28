package com.lts.FBA.FlightBookingApplication.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lts.FBA.FlightBookingApplication.Entity.Embeded.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Airports")
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String airportName;

	@Column(nullable = false, unique = true)
	private String airportCode;

	@Column(nullable = false)
	private String displayName;

	@Column(nullable = false)
	private String airPortType;

	@Column(nullable = false)
	private boolean availability;

	@Column(nullable = false)
	private double longitude;

	@Column(nullable = false)
	private double latitude;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "departureAirport")
	@JsonManagedReference(value = "depotAir-flights")
	private List<Flight> departureFlights;

	@OneToMany(mappedBy = "arrivalAirport")
	@JsonManagedReference(value = "arrivalAir-flights")
	private List<Flight> arrivalFlights;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime creationTm;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime lastUpdateTm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAirPortType() {
		return airPortType;
	}

	public void setAirPortType(String airPortType) {
		this.airPortType = airPortType;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Flight> getDepartureFlights() {
		return departureFlights;
	}

	public void setDepartureFlights(List<Flight> departureFlights) {
		this.departureFlights = departureFlights;
	}

	public List<Flight> getArrivalFlights() {
		return arrivalFlights;
	}

	public void setArrivalFlights(List<Flight> arrivalFlights) {
		this.arrivalFlights = arrivalFlights;
	}

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

}