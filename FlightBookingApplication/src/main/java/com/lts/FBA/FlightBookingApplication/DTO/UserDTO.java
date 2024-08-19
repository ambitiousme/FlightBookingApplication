package com.lts.FBA.FlightBookingApplication.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

	private Long id;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	private String username;

	@NotBlank(message = "Password is mandatory")
	@Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
	private String password;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Fathers Name is mandatory")
	private String fathersName;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotNull(message = "Age is mandatory")
	private Integer age;

	private LocalDate dateOfBirth;

	private AddressDTO address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", fathersName=" + fathersName + ", email=" + email + ", age=" + age + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

}
