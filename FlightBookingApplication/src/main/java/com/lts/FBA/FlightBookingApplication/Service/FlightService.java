package com.lts.FBA.FlightBookingApplication.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.lts.FBA.FlightBookingApplication.DTO.RegisterFlightDTO;
import com.lts.FBA.FlightBookingApplication.DTO.SearchFlightDTO;

public interface FlightService {

	List<SearchFlightDTO> searchFlights(String flightFrom, String flightTo, LocalDate date);

	RegisterFlightDTO createFlight(RegisterFlightDTO flightDTO);

	Optional<RegisterFlightDTO> getFlightByNumber(String flightNumber);

	Optional<RegisterFlightDTO> updateFlight(Long flightId, RegisterFlightDTO flightDTO);

	Optional<RegisterFlightDTO> deleteFlight(String flightNumber);

	List<RegisterFlightDTO> insertAllFlights(Iterable<RegisterFlightDTO> flightList) throws Exception;

}
