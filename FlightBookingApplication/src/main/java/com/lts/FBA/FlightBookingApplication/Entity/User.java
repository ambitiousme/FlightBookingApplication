package com.lts.FBA.FlightBookingApplication.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.lts.FBA.FlightBookingApplication.Entity.Embeded.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String fathersName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "contact", nullable = false, unique = true)
	private String contactNo;

	@Column(nullable = false)
	private int age;

	@Column(name = "DOB", nullable = false)
	private LocalDate dateOfBirth;

	@Column(nullable = false)
	private String role;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Passenger> passengers;

	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;

	@OneToMany(mappedBy = "user")
	private List<PaymentMethod> paymentMethods;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
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