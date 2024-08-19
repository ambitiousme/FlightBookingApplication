package com.lts.FBA.FlightBookingApplication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lts.FBA.FlightBookingApplication.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
