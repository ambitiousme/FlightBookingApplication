package com.lts.FBA.FlightBookingApplication.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lts.FBA.FlightBookingApplication.DTO.PassengerDTO;
import com.lts.FBA.FlightBookingApplication.Exception.ResourceNotFoundException;
import com.lts.FBA.FlightBookingApplication.Service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
@Validated
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@PostMapping("/addPassenger")
	public ResponseEntity<PassengerDTO> addPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {

		System.out.println("meeeeee" + passengerDTO);
		PassengerDTO createdPassenger = passengerService.addPassenger(passengerDTO);
		return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable("id") Long passengerId) {
		PassengerDTO passengerDTO = passengerService.getPassengerById(passengerId)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + passengerId));
		return new ResponseEntity<>(passengerDTO, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable("id") Long passengerId,
			@Valid @RequestBody PassengerDTO passengerDTO) {
		PassengerDTO updatedPassenger = passengerService.updatePassenger(passengerId, passengerDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + passengerId));
		return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePassenger(@PathVariable("id") Long passengerId) {
		passengerService.deletePassenger(passengerId)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + passengerId));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
		List<PassengerDTO> passengers = passengerService.getAllPassengers();
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	@GetMapping("/getPByUserId/{id}")
	public ResponseEntity<List<PassengerDTO>> getPassengerByUserId(@PathVariable("id") Long userId) {
		List<PassengerDTO> passengers = passengerService.getPassengersByUserId(userId);
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	@GetMapping("/getPByBookingId/{id}")
	public ResponseEntity<List<PassengerDTO>> getPassengerByBookingId(@PathVariable("id") Long bookingId) {
		List<PassengerDTO> passengers = passengerService.getPassengersByBookingId(bookingId);
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

}
