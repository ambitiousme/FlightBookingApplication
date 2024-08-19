package com.lts.FBA.FlightBookingApplication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lts.FBA.FlightBookingApplication.DTO.UserDTO;
import com.lts.FBA.FlightBookingApplication.Entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserDTO userDTO);

	UserDTO toDto(User user);
}