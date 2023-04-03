package com.movie.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.movie.entity.User;
import com.movie.exception.ResourceNotFoundException;
import com.movie.repository.UserRepository;
import com.movie.request.UserRequest;
import com.movie.response.UserResponse;
import com.movie.service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		User user = this.modelMapper.map(userRequest, User.class);
		User user1 = this.userRepository.save(user);
		return this.modelMapper.map(user1, UserResponse.class);
	}

	@Override
	public UserResponse upateUser(UserRequest userRequest, @Valid Long userId) {
		User foundUser = this.modelMapper.map(this.getUserByUserId(userId), User.class);
		foundUser.setEmailId(userRequest.getEmailId());
		foundUser.setPassword(userRequest.getUserMobileNumber());
		foundUser.setUserMobileNumber(userRequest.getUserMobileNumber());
		foundUser.setUserName(userRequest.getUserName());
		User updatedUser = this.userRepository.save(foundUser);
		return this.modelMapper.map(updatedUser, UserResponse.class);
	}

	@Override
	public List<UserResponse> getUserByKeyword(String keyword) {
		List<User> userBykeyWord = this.userRepository.findByKeyword(keyword);
		return userBykeyWord.stream().map(p -> this.modelMapper.map(p, UserResponse.class))
				.collect(Collectors.toList());

	}

	@Override
	public UserResponse getUserByUserId(Long userId) {
		User foundUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,
						String.format("User with id %d not found", userId)));

		return this.modelMapper.map(foundUser, UserResponse.class);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return this.userRepository.findAll().stream().map(Source -> this.modelMapper.map(Source, UserResponse.class))
				.collect(Collectors.toList());

	}

	@Override
	public void deleteUser(Long userId) {
		User foundUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,
						String.format("User with id %d not found", userId)));

		this.userRepository.delete(foundUser);

	}

}
