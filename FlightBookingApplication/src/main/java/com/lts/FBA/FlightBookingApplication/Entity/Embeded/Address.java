package com.lts.FBA.FlightBookingApplication.Entity.Embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(nullable = false)
	private String addressLine;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String country;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String addressLine, String city, String state, String country) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", country=" + country
				+ "]";
	}

}
