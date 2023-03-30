package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.request.TheaterRequest;
import com.movie.response.NearByTheaterResponse;
import com.movie.response.TheaterResponse;
import com.movie.service.TheaterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/theater/")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;
     
	@PostMapping("/create/")
	public ResponseEntity<TheaterResponse> createTheater(@Valid @RequestBody TheaterRequest theaterRequest) {
		TheaterResponse theaterResponse = this.theaterService.createTheater(theaterRequest);
		return new ResponseEntity<TheaterResponse>(theaterResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{theaterId}")
	public ResponseEntity<TheaterResponse> getTheatreByTheaterId(@PathVariable Long theaterId) {
		TheaterResponse theaterById = this.theaterService.getTheaterByTheaterId(theaterId);
		System.out.println("theater value"+theaterById.toString());
		return new ResponseEntity<TheaterResponse>(theaterById, HttpStatus.OK);

	}
	
	@GetMapping("/search/nearby")
	
public ResponseEntity<List<NearByTheaterResponse>> getNearByTheaters(
		@RequestParam(value = "latitude", required = true) Double latitude,
		@RequestParam(value = "longitude", required = true)Double longitude ,
		@RequestParam(value = "radius", required = false, defaultValue = "15.00") Double radius) {
		List<NearByTheaterResponse> nearbyTheaters = this.theaterService.getNearByTheater(latitude,longitude, radius);
		return new ResponseEntity<List<NearByTheaterResponse>>(nearbyTheaters, HttpStatus.OK);

	}
}
