package com.lts.FBA.FlightBookingApplication.Service;

import java.util.List;
import java.util.Optional;

import com.lts.FBA.FlightBookingApplication.DTO.UserDTO;

public interface UserService {

	UserDTO registerUser(UserDTO userDTO);

	Optional<UserDTO> getUserById(Long userId);

	Optional<UserDTO> updateUser(Long userId, UserDTO userDTO);

	Optional<Void> deleteUser(Long userId);

	List<UserDTO> getAllUsers();

}
