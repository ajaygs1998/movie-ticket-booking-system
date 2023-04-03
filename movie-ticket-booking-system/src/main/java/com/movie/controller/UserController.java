package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.ApiResponse;
import com.movie.request.UserRequest;
import com.movie.response.UserResponse;
import com.movie.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/app/user/")
public class UserController {
	@Autowired
	UserService userService;
     
	@PostMapping("/create/")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
		UserResponse createdUser = this.userService.createUser(userRequest);
		return new ResponseEntity<UserResponse>(createdUser, HttpStatus.OK);
	}

	@GetMapping("/find/{userId}")
	public ResponseEntity<UserResponse> getUserByUserId(@PathVariable Long userId) {
		UserResponse userById = this.userService.getUserByUserId(userId);
		return new ResponseEntity<UserResponse>(userById, HttpStatus.OK);

	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable Long userId,
			@RequestBody UserRequest userRequest) {
		UserResponse updatedUser = this.userService.upateUser(userRequest, userId);
		return new ResponseEntity<UserResponse>(updatedUser, HttpStatus.OK);
	}

	@GetMapping("/search/keywords/{keyword}")
	public ResponseEntity<?> getUserByKeyword(@PathVariable String keyword) {
		List<UserResponse> user = this.userService.getUserByKeyword(keyword);
		return new ResponseEntity<>(
				(!user.isEmpty()) ? user : new ApiResponse("User not found with keyword: " + keyword, true),
				HttpStatus.OK);
	}

	@GetMapping("/find/all")
	public ResponseEntity<?> getAllUsers() {
		List<UserResponse> users = this.userService.getAllUsers();
		return new ResponseEntity<>((!users.isEmpty()) ? users : new ApiResponse("User list is empty ", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
}
