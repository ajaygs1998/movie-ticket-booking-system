package com.movie.service;

import java.util.List;

import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;

import jakarta.validation.Valid;

public interface ReviewService {

	ReviewResponse createReview(@Valid ReviewRequest reviewRequest, Long userId, Long movieId);
	// user

	ReviewResponse getReviewByReviewId(Long reviewId);

	List<ReviewResponse> getAllReviews();

	List<ReviewResponse> getReviewsByMovieId(Long movieId);

}
