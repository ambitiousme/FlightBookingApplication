package com.lts.FBA.FlightBookingApplication.Service.Impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lts.FBA.FlightBookingApplication.DTO.FlightSeatDTO;
import com.lts.FBA.FlightBookingApplication.DTO.RegisterFlightDTO;
import com.lts.FBA.FlightBookingApplication.DTO.SearchFlightDTO;
import com.lts.FBA.FlightBookingApplication.Entity.AirlineSeat;
import com.lts.FBA.FlightBookingApplication.Entity.Airport;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;
import com.lts.FBA.FlightBookingApplication.Entity.FlightSeat;
import com.lts.FBA.FlightBookingApplication.Exception.ResourceNotFoundException;
import com.lts.FBA.FlightBookingApplication.Mapper.AirlineSeatToFlightSeatMapper;
import com.lts.FBA.FlightBookingApplication.Mapper.FlightMapper;
import com.lts.FBA.FlightBookingApplication.Mapper.FlightSeatMapper;
import com.lts.FBA.FlightBookingApplication.Repository.AirlineRepository;
import com.lts.FBA.FlightBookingApplication.Repository.AirlineSeatRepostiory;
import com.lts.FBA.FlightBookingApplication.Repository.AirportRepository;
import com.lts.FBA.FlightBookingApplication.Repository.FlightRepository;
import com.lts.FBA.FlightBookingApplication.Repository.FlightSeatsRepository;
import com.lts.FBA.FlightBookingApplication.Service.FlightSeatService;
import com.lts.FBA.FlightBookingApplication.Service.FlightService;
import com.lts.FBA.FlightBookingApplication.Utility.DistanceCalculator;

@Service
public class FlightServiceImpl implements FlightService {

	private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	FlightSeatMapper flightSeatMapper;

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	FlightSeatService flightSeatService;

	@Autowired
	AirlineRepository airlineRepo;

	@Autowired
	AirportRepository airportRepo;
	@Autowired
	AirlineSeatRepostiory airlineSeatRepo;
	@Autowired
	FlightSeatsRepository flightSeatRepo;

	@Override
	public List<SearchFlightDTO> searchFlights(String flightFrom, String flightTo, LocalDate date) {

		log.debug(
				"Entering into 'searchFlights(String flightFrom, String flightTo, LocalDate date) return List<SearchFlightDTO>' "
						+ "of FlightServiceImpl.class Parameters: " + " flightFrom: " + flightFrom + " flightTo: "
						+ flightTo + "  date: " + date);

		List<SearchFlightDTO> flightDTOList = new ArrayList<>();

		try {
			List<Flight> allFlights = flightRepo.findFlightsBySourceDestinationAndFlightDate(flightFrom, flightTo,
					date);

			for (Flight flight : allFlights) {

				SearchFlightDTO flightDTO = new SearchFlightDTO();

				flightDTO = flightMapper.toSearchDTO(flight);

				flightDTO.setFlightDate(date);

				flightDTO.setAirlineName(airlineRepo.findById(flight.getAirline().getId()).get().getName());
				flightDTO.setArrivalAirportName(
						airportRepo.findById(flight.getArrivalAirport().getId()).get().getAirportName());
				flightDTO.setArrivalAirportCode(
						airportRepo.findById(flight.getArrivalAirport().getId()).get().getAirportCode());
				flightDTO.setDepartureAirportName(
						airportRepo.findById(flight.getDepartureAirport().getId()).get().getAirportName());
				flightDTO.setDepartureAirportCode(
						airportRepo.findById(flight.getDepartureAirport().getId()).get().getAirportCode());

				// Need to set seatAvailabilty

				flightDTOList.add(flightDTO);
			}

		} catch (Exception e) {
			new ResourceNotFoundException("Got one exception here: " + e);
			e.printStackTrace();
			log.error("Exception ocuured: " + e);
		}

		log.debug(
				"Returning from 'searchFlights(String flightFrom, String flightTo, LocalDate date) return List<SearchFlightDTO>' "
						+ "of FlightServiceImpl.class returned param: " + " flightFrom: " + flightDTOList);

		return flightDTOList;
	}

	@Override
	@Transactional
	public RegisterFlightDTO createFlight(RegisterFlightDTO flightDTO) {

		log.debug("Entering into 'createFlight(RegisterFlightDTO flightDTO) return RegisterFlightDTO' "
				+ "of FlightServiceImpl.class Parameters: " + " RegisterFlightDTO: " + flightDTO.toString());

		Flight regFlight = flightMapper.toEntity(flightDTO);

		log.debug("regFlight : " + regFlight);

		if (regFlight.getDepartureTime() != null && regFlight.getArrivalTime() != null)
			regFlight.setDuration(Duration.between(regFlight.getDepartureTime(), regFlight.getArrivalTime()));

		try {

			distanceCalculatorBtwAirports(regFlight);

		} catch (Exception e) {
			new ResourceNotFoundException("Got one exception in distance Calculation : " + e);
			e.printStackTrace();
		}

		
		Flight savedFlight = flightRepo.save(regFlight);

		log.debug("savedFlight : " + savedFlight);

		RegisterFlightDTO mappedFlight = flightMapper.toRegDTO(savedFlight);

		log.debug("mappedFlight : " + mappedFlight);

		List<AirlineSeat> airlineSeatList = airlineSeatRepo.findSeatsById(savedFlight.getAirline().getId());
		List<FlightSeatDTO> flightSeatList = new ArrayList<>();
		for (AirlineSeat airlineSeat : airlineSeatList) {

			FlightSeat flightSeat = new FlightSeat();
			AirlineSeatToFlightSeatMapper.airlineToFlightSeat(airlineSeat, flightSeat, savedFlight);
			
			
			flightSeatList.add(flightSeatMapper.toDTO(flightSeat));
			
		}

		try {
			flightSeatService.assignSeatsForFlight(flightSeatList);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Got one exception while adding flight seats: " + e);
		}

		log.debug("Returning from 'createFlight(RegisterFlightDTO flightDTO) return RegisterFlightDTO' "
				+ "of FlightServiceImpl.class" + " returned param: " + " flightFrom: " + mappedFlight);
		return mappedFlight;
	}

	@Override
	public Optional<RegisterFlightDTO> getFlightByNumber(String flightNumber) {

		log.debug("Entering into 'getFlightById(Long flightId) return Optional<RegisterFlightDTO>' "
				+ "of FlightServiceImpl.class Parameters: " + " flightNumber : " + flightNumber);

		log.debug("Returning from 'getFlightById(Long flightId) return Optional<RegisterFlightDTO>' "
				+ "of FlightServiceImpl.class" + " returned param: ");

		return flightRepo.findByFlightNumber(flightNumber).map(flightMapper::toRegDTO);

	}

	@Override
	public Optional<RegisterFlightDTO> updateFlight(Long flightId, RegisterFlightDTO flightDTO) {
		log.debug(
				"Entering into 'updateFlight(Long flightId, RegisterFlightDTO flightDTO) return Optional<RegisterFlightDTO>'"
						+ "of FlightServiceImpl.class Parameters: " + " flightId : " + flightId + " flightDTO : "
						+ flightDTO);

		return flightRepo.findById(flightId).map(existingFlight -> {
			Flight flight = flightMapper.toEntity(flightDTO);
			flight.setId(existingFlight.getId());
			log.debug(
					"Returning from 'updateFlight(Long flightId, RegisterFlightDTO flightDTO) return Optional<RegisterFlightDTO>'"
							+ "of FlightServiceImpl.class returned param: ");
			return flightMapper.toRegDTO(flightRepo.save(flight));
		});
	}

	@Override
	@Transactional
	public Optional<RegisterFlightDTO> deleteFlight(String flightNumber) throws ResourceNotFoundException {

		log.debug("Entering into 'deleteFlight(Long flightId) return Optional<RegisterFlightDTO>' Parameters: "
				+ "of FlightServiceImpl.class" + " flightNumber : " + flightNumber);

		Flight flight = flightRepo.findByFlightNumber(flightNumber).orElseThrow(
				() -> new ResourceNotFoundException("Flight does not exist with flight Number : " + flightNumber));

		RegisterFlightDTO flightDTO = flightMapper.toRegDTO(flight);

		flightSeatService.deleteByFlightId(flight.getId());

		flightRepo.deleteByFlightNumber(flightNumber);

		log.debug("Returning from 'deleteFlight(Long flightId) return Optional<RegisterFlightDTO>' "
				+ "of FlightServiceImpl.class" + " returned param: ");

		return Optional.of(flightDTO);

	}

	@Override
	@Transactional
	public List<RegisterFlightDTO> insertAllFlights(Iterable<RegisterFlightDTO> flightList) throws Exception {

		log.debug("Entering into 'insertAllFlights(Iterable<RegisterFlightDTO> return List<RegisterFlightDTO>'"
				+ "of FlightServiceImpl.class Parameters: " + " flightId : " + flightList.toString());

		List<RegisterFlightDTO> flightDTOList = new ArrayList<>();

		for (RegisterFlightDTO flightDTO : flightList)
			flightDTOList.add(createFlight(flightDTO));

		log.debug("Returning from 'deleteFlight(Long flightId) return Optional<RegisterFlightDTO>'"
				+ "of FlightServiceImpl.class returned param: flightDTOList : " + flightDTOList);

		return flightDTOList;

	}

	private void distanceCalculatorBtwAirports(Flight flight) throws Exception {

		log.debug("Entering into 'distanceCalculatorBtwAirports(Flight flight) return void'"
				+ "of FlightServiceImpl.class  Parameters: " + " flight : " + flight.toString());
		Long srcPortId = 0L;
		Long dstPortId = 0L;
		double flightDistance = 0.0D;

		if (flight.getDepartureAirport().getId() != null)
			srcPortId = flight.getDepartureAirport().getId();

		if (flight.getArrivalAirport().getId() != null)
			dstPortId = flight.getArrivalAirport().getId();

		Optional<Airport> departurePort = airportRepo.findById(srcPortId);
		Optional<Airport> arrivalPort = airportRepo.findById(dstPortId);

		log.debug("departurePort after = " + departurePort.toString());
		log.debug("departurePort after = " + arrivalPort.toString());

		if (departurePort.isPresent() && arrivalPort.isPresent())
			flightDistance = DistanceCalculator.calculateHaversineDistance(departurePort.get().getLatitude(),
					departurePort.get().getLongitude(), arrivalPort.get().getLatitude(),
					arrivalPort.get().getLongitude());

		log.debug("Flight distance = " + flightDistance);
		flight.setTotalDistance(flightDistance);

		log.debug("Returning from 'distanceCalculatorBtwAirports(Flight flight) return void'"
				+ "of FlightServiceImpl.class returned param: ");

	}
}
