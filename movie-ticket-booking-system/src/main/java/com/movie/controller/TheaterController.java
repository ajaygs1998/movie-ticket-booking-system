package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.request.TheaterRequest;
import com.movie.response.TheaterResponse;
import com.movie.service.TheaterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/theater/")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;
     
	@PostMapping("/create/")
	public ResponseEntity<TheaterResponse> createTheatre(@Valid @RequestBody TheaterRequest theaterRequest) {
		TheaterResponse theaterResponse = this.theaterService.createTheater(theaterRequest);
		return new ResponseEntity<TheaterResponse>(theaterResponse, HttpStatus.CREATED);
	}
}
