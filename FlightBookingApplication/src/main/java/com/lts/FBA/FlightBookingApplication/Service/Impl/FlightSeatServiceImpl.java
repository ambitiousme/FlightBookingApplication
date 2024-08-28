package com.lts.FBA.FlightBookingApplication.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lts.FBA.FlightBookingApplication.DTO.FlightSeatDTO;
import com.lts.FBA.FlightBookingApplication.Mapper.FlightSeatMapper;
import com.lts.FBA.FlightBookingApplication.Repository.FlightSeatsRepository;
import com.lts.FBA.FlightBookingApplication.Service.FlightSeatService;


@Service
public class FlightSeatServiceImpl implements FlightSeatService {
	
	private static final Logger log = LoggerFactory.getLogger(FlightSeatServiceImpl.class);

	@Autowired
	FlightSeatsRepository repo;

	@Autowired
	FlightSeatMapper mapper;

	@Override
	public List<FlightSeatDTO> assignSeatsForFlight(List<FlightSeatDTO> seats) {
		return repo.saveAll(seats.stream().map(mapper::toEntity).collect(Collectors.toList())).stream()
				.map(mapper::toDTO).collect(Collectors.toList());
	}
	@Transactional
	@Override
	public void deleteByFlightId(Long flightId) {
		repo.deleteByFlightId(flightId);
	}
	
	

}
