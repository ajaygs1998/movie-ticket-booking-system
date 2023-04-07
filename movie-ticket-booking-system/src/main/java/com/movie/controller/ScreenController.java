package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.ApiResponse;
import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;
import com.movie.service.ScreenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/screen/")
public class ScreenController {

	/*
	 *    //this will be useful for theater admins
       PUT /theaters/{id}/screens/{screenId}: Updates a specific screen for a specific theater by ID
    DELETE /theaters/{id}/screens/{screenId}: Deletes a specific screen for a specific theater by ID

	 */
	@Autowired
	private ScreenService screenService;

	@PostMapping("theater/{theaterId}/create/")
	public ResponseEntity<ScreenResponse> createScreenInTheater(@Valid @RequestBody ScreenRequest screenRequest,
			@PathVariable Long theaterId) {
		return new ResponseEntity<>(this.screenService.createScreenInTheater(screenRequest, theaterId),
				HttpStatus.CREATED);
	}

	@GetMapping("/search/by-theater/{theaterId}")
	public ResponseEntity<List<ScreenResponse>> getAllScreensInTheater(@PathVariable Long theaterId) {
		return new ResponseEntity<List<ScreenResponse>>(this.screenService.getAllScreensInTheater(theaterId),
				HttpStatus.OK);

	}

	@GetMapping("/{screenId}")
	public ResponseEntity<ScreenResponse> getScreenByScreenId(@PathVariable Long screenId) {
		return new ResponseEntity<>(this.screenService.getScreenByScreenId(screenId), HttpStatus.CREATED);
	}

	@PutMapping("theater/{theaterId}/screens/{screenId}")
	public ResponseEntity<ScreenResponse> updateScreen(@RequestBody ScreenRequest screenRequest,
			@PathVariable Long theaterId, @PathVariable Long screenId) {
		return new ResponseEntity<>(this.screenService.updateScreen(screenRequest, theaterId, screenId),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/{screenId}")
	public ResponseEntity<ApiResponse> deleteScreenByScreenId(@PathVariable Long screenId) {
		this.screenService.deleteScreenByScreenId(screenId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Movie Deleted Successfully", true), HttpStatus.OK);
	}
}
