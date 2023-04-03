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

import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;
import com.movie.response.TheaterResponse;
import com.movie.service.ScreenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/screen/")
public class ScreenController {

	@Autowired
	private ScreenService screenService;

	@PostMapping("theater/{theaterId}/create")
	public ResponseEntity<List<ScreenResponse>> createScreenInTheater(
			@Valid @RequestBody List<ScreenRequest> screenRequest, @PathVariable Long theaterId) {
		List<ScreenResponse> savedScreen = this.screenService.createScreenInTheater(screenRequest, theaterId);
		return new ResponseEntity<List<ScreenResponse>>(savedScreen, HttpStatus.CREATED);
	}

	@GetMapping("/search/{theaterId}")
	public ResponseEntity<List<ScreenResponse>> getAllScreensInTheater(@PathVariable Long theaterId) {
		List<ScreenResponse> screenList = this.screenService.getAllScreensInTheater(theaterId);
		return new ResponseEntity<List<ScreenResponse>>(screenList, HttpStatus.OK);

	}
}