package com.lts.FBA.FlightBookingApplication.Entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.lts.FBA.FlightBookingApplication.Utility.UniqueNumberGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String flightNumber;

	@PrePersist
	protected void onCreate() {
		this.flightNumber = UniqueNumberGenerator.generateFlightNumber();
	}

	@Column(nullable = false)
	private String source;

	@Column(nullable = false)
	private String destination;

	@Column(name = "distance", nullable = false)
	private double totalDistance;

	@ManyToOne
	@JoinColumn(name = "airline_id", nullable = false)
	private Airline airline;

	@ManyToOne
	@JoinColumn(name = "departure_airport_id", nullable = false)
	private Airport departureAirport;

	@ManyToOne
	@JoinColumn(name = "arrival_airport_id", nullable = false)
	private Airport arrivalAirport;

	@Column(nullable = false)
	private LocalDateTime departureTime;

	@Column(nullable = false)
	private LocalDateTime arrivalTime;

	@Column(nullable = false)
	private Duration duration;

	@Column(nullable = false)
	private Double price;

	@OneToMany(mappedBy = "flight")
	private List<FlightSeat> seats;

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

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
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

	public List<FlightSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<FlightSeat> seats) {
		this.seats = seats;
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
