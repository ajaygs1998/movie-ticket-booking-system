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

import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;
import com.movie.service.SeatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/seat/")
public class SeatController {
	
	@Autowired
	SeatService seatService;
	
	@PostMapping("theater/{theaterId}/screen/{screenId}/create")
	public ResponseEntity<List<SeatResponse>>  addSeatsInScreen(
			@Valid @RequestBody List<SeatRequest> seatRequest, @PathVariable Long theaterId, @PathVariable Long screenId) {
		List<SeatResponse> savedSeats = this.seatService.addSeatsInScreen(seatRequest, theaterId);
		return new ResponseEntity<List<SeatResponse>>(savedSeats, HttpStatus.CREATED);
	}
 //Seach seats in particular theater or screen 
	@GetMapping("/search/seats/")
	public ResponseEntity<List<SeatResponse>> getAllSeatsInTheater(@RequestParam Long theaterId, @RequestParam Long ScreenId) {
		List<SeatResponse> screenList = this.seatService.getAllSeatsInTheater(theaterId);
		return new ResponseEntity<List<SeatResponse>>(screenList, HttpStatus.OK);
	}

}
