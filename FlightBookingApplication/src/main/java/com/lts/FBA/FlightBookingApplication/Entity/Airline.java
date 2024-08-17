package com.lts.FBA.FlightBookingApplication.Entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Airlines")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
    
    @Column(nullable = false)
    private String manufacturer;
    
    @Column(nullable = false)
    private int EconomySeatNum;
    
    @Column(nullable = false)
    private int BusinessSeatNum;
    
    @Column(nullable = false)
    private int totalSeats;
      
    @Column(nullable = false)
    private String status;//Indicates whether the aircraft is active, under maintenance, or retired.
    
    @Column(nullable = false)
    private LocalDateTime lastMaintenanceDate;
    
    @OneToMany(mappedBy = "airline")
    private List<Flight> Seat;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getEconomySeatNum() {
		return EconomySeatNum;
	}

	public void setEconomySeatNum(int economySeatNum) {
		EconomySeatNum = economySeatNum;
	}

	public int getBusinessSeatNum() {
		return BusinessSeatNum;
	}

	public void setBusinessSeatNum(int businessSeatNum) {
		BusinessSeatNum = businessSeatNum;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}

	public void setLastMaintenanceDate(LocalDateTime lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	public List<Flight> getSeat() {
		return Seat;
	}

	public void setSeat(List<Flight> seat) {
		Seat = seat;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}