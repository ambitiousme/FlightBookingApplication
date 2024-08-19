package com.lts.FBA.FlightBookingApplication.DTO;

import javax.validation.constraints.NotBlank;

public class AddressDTO {

	@NotBlank
	private String addressLine;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String country;

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
}
