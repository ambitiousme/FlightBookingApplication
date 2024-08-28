package com.lts.FBA.FlightBookingApplication.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lts.FBA.FlightBookingApplication.DTO.RegisterFlightDTO;
import com.lts.FBA.FlightBookingApplication.DTO.SearchFlightDTO;
import com.lts.FBA.FlightBookingApplication.Exception.ResourceNotFoundException;
import com.lts.FBA.FlightBookingApplication.Service.FlightService;
import com.lts.FBA.FlightBookingApplication.Service.Impl.FlightSeatServiceImpl;

@RestController
@RequestMapping("/api/users")
@Validated
public class FlightController {

	private static final Logger log = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	FlightService flightService;

	@GetMapping("/getFlight/{flightFrom}/{flightTo}/{date}")
	public ResponseEntity<List<SearchFlightDTO>> searchFlights(@PathVariable("flightFrom") String flightFrom,
			@PathVariable("flightTo") String flightTo,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		log.debug(
				"Entering into 'searchFlights(String flightFrom, String flightTo, LocalDate date) return ResponseEntity<List<SearchFlightDTO>>' "
						+ "of FlightController.class Parameters: " + " flightFrom: " + flightFrom + " flightTo: "
						+ flightTo + "  date: " + date);

		List<SearchFlightDTO> flightList = flightService.searchFlights(flightFrom, flightTo, date);

		log.debug(
				"Returning from 'searchFlights(String flightFrom, String flightTo, LocalDate date) return ResponseEntity<List<SearchFlightDTO>>' "
						+ "of FlightController.class returned param: " + " flightList: " + flightList.toString());

		return new ResponseEntity<>(flightList, HttpStatus.OK);
	}

	@PostMapping("/createFlight")
	public ResponseEntity<RegisterFlightDTO> createFlight(@Valid @RequestBody RegisterFlightDTO flightDTO) {

		log.debug("Entering into 'createFlight(RegisterFlightDTO flightDTO) return ResponseEntity<RegisterFlightDTO>' "
				+ "of FlightController.class");

		RegisterFlightDTO createdUser = flightService.createFlight(flightDTO);

		log.debug("Returning from 'createFlight(RegisterFlightDTO flightDTO) return ResponseEntity<RegisterFlightDTO>' "
				+ "of FlightController.class returned param: ");
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/getFlightByNumber/{flightNumber}")
	public ResponseEntity<RegisterFlightDTO> searchFlightByFlightNum(
			@Valid @PathVariable("flightNumber") String flightNumber) {
		log.debug("Entering into 'createFlight(RegisterFlightDTO flightDTO) return ResponseEntity<RegisterFlightDTO>' "
				+ "of FlightController.class parameter : flightNumber " + flightNumber);

		RegisterFlightDTO flightList = flightService.getFlightByNumber(flightNumber).orElseThrow(
				() -> new ResourceNotFoundException("Flight not found with flight Number : " + flightNumber));

		return new ResponseEntity<>(flightList, HttpStatus.OK);

	}

	@DeleteMapping("/deleteFlightByNumber/{flightNumber}")
	public ResponseEntity<Optional<RegisterFlightDTO>> deleteFlight(
			@Valid @PathVariable("flightNumber") String flightNumber) {

		Optional<RegisterFlightDTO> deletedFlight = flightService.deleteFlight(flightNumber);
		
		if (deletedFlight.isPresent()) {
	        return new ResponseEntity<>(deletedFlight, HttpStatus.OK); // 
	    } else {
	        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND); 
	    }
	}

}
