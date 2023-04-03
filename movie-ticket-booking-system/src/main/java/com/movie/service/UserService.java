package com.movie.service;

import java.util.List;

import com.movie.request.UserRequest;
import com.movie.response.UserResponse;

import jakarta.validation.Valid;

public interface UserService {

	UserResponse upateUser(UserRequest userRequest, @Valid Long userId);

	List<UserResponse> getUserByKeyword(String keyword);

	UserResponse getUserByUserId(Long userId);

	List<UserResponse> getAllUsers();

	void deleteUser(Long userId);

	UserResponse createUser(UserRequest userRequest);

}
