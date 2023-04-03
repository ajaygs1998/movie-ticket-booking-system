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
import com.movie.request.ShowDetailsRequest;
import com.movie.response.CustomResponse;
import com.movie.response.ShowDetailsResponse;
import com.movie.service.ShowDetailsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app/showdetails/")
public class ShowDetailsController {

	@Autowired
	private ShowDetailsService showDetailsService;

	@PostMapping("create/schedule")
	public ResponseEntity<ShowDetailsResponse> createShowDetails(
			@Valid @RequestBody ShowDetailsRequest showDetailsRequest) {
		ShowDetailsResponse createShowDetails = this.showDetailsService.createShowDetails(showDetailsRequest);
		return new ResponseEntity<ShowDetailsResponse>(createShowDetails, HttpStatus.CREATED);
	}

	// Implementation to avoid show duplication
	@PostMapping("/showdetails/movies/{movieId}/theater/{theaterId}")
	public ResponseEntity<?> createShowDetails(@Valid @PathVariable Long movieId, @PathVariable Long theaterId,
			@RequestBody ShowDetailsResponse showDetailsRequest) {

		CustomResponse createShowDetails = this.showDetailsService.createShowDetails(showDetailsRequest, movieId,
				theaterId);
		return new ResponseEntity<>(createShowDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getbyId/{showDetailsId}")
	public ResponseEntity<ShowDetailsResponse> getShowDetailsByShowDetailsId(@PathVariable Long showDetailsId) {
		ShowDetailsResponse showDetailsById = this.showDetailsService.getShowDetailsByShowDetailsId(showDetailsId);
		return new ResponseEntity<ShowDetailsResponse>(showDetailsById, HttpStatus.OK);
	}

	@GetMapping("/get/list/showDetails/")
	public ResponseEntity<?> getAllShowDetails() {
		List<ShowDetailsResponse> showDetails = this.showDetailsService.getAllShowDetails();
		return new ResponseEntity<>(
				(!showDetails.isEmpty()) ? showDetails : new ApiResponse("ShowDetails list is empty ", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/showDetails/{showDetailsId}")
	public ResponseEntity<ApiResponse> deleteShowDetails(@PathVariable Long showDetailsId) {
		this.showDetailsService.deleteShowDetails(showDetailsId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("ShowDetails Deleted Successfully", true),
				HttpStatus.OK);
	}

	@PutMapping("/update/{showDetailsId}")
	public ResponseEntity<ShowDetailsResponse> updateShowDetails(@Valid @PathVariable Long showDetailsId,
			@RequestBody ShowDetailsResponse showDetailsRequest) {
		ShowDetailsResponse updatedShowDetails = this.showDetailsService.upateShowDetails(showDetailsRequest,
				showDetailsId);
		return new ResponseEntity<ShowDetailsResponse>(updatedShowDetails, HttpStatus.OK);
	}

	@GetMapping("/search/showDetails/{movieId}")
	public ResponseEntity<?> getShowDetailsByMovieId(@PathVariable Long movieId) {
		System.out.println("inside search");
		List<ShowDetailsResponse> serchedshow = this.showDetailsService.getShowDetailsByMovieId(movieId);

		return new ResponseEntity<>((!serchedshow.isEmpty()) ? serchedshow
				: new ApiResponse("Show not found with movieId: " + movieId, true), HttpStatus.OK);
	}

}
