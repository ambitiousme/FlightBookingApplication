package com.lts.FBA.FlightBookingApplication.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lts.FBA.FlightBookingApplication.DTO.UserDTO;
import com.lts.FBA.FlightBookingApplication.Entity.User;
import com.lts.FBA.FlightBookingApplication.Mapper.UserMapper;
import com.lts.FBA.FlightBookingApplication.Repository.UserRepository;
import com.lts.FBA.FlightBookingApplication.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> updateUser(Long userId, UserDTO userDTO) {
        return userRepository.findById(userId).map(existingUser -> {
            User user = userMapper.toEntity(userDTO);
            user.setId(existingUser.getId());
            return userMapper.toDto(userRepository.save(user));
        });
    }

    @Override
    public Optional<Void> deleteUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return null;
        });
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}