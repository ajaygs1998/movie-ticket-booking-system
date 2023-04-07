package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.ApiResponse;
import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;
import com.movie.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/review/")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@PostMapping("/user/{userId}/movie/{movieId}")
	public ResponseEntity<ReviewResponse> doRatingForMovie(@Valid @RequestBody ReviewRequest reviewRequest,
			@PathVariable Long userId, @PathVariable Long movieId) {
		ReviewResponse createReview = this.reviewService.createReview(reviewRequest, userId, movieId);
		return new ResponseEntity<ReviewResponse>(createReview, HttpStatus.CREATED);
	}


	@GetMapping("/{reviewId}")
	public ResponseEntity<ReviewResponse> getReviewByReviewId(@PathVariable Long reviewId) {
		ReviewResponse reviewById = this.reviewService.getReviewByReviewId(reviewId);
		return new ResponseEntity<ReviewResponse>(reviewById, HttpStatus.OK);
	}
	
	@GetMapping("/movie/{movieId}")
	public ResponseEntity<List<ReviewResponse>> getReviewsByMoviewId(@PathVariable Long movieId) {
		List<ReviewResponse> movieReviews = this.reviewService.getReviewsByMovieId(movieId);
		return new ResponseEntity<List<ReviewResponse>>(movieReviews, HttpStatus.OK);
	}

	@GetMapping("/list/")
	public ResponseEntity<?> getAllReviews() {
		List<ReviewResponse> reviews = this.reviewService.getAllReviews();
		return new ResponseEntity<>((!reviews.isEmpty()) ? reviews : new ApiResponse("Review list is empty ", true),
				HttpStatus.OK);
	}

}
