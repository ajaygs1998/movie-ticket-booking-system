package com.movie.service;

import java.util.List;
import java.util.TreeSet;


import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;

import jakarta.validation.Valid;

public interface ReviewService {

	ReviewResponse createReview(@Valid ReviewRequest reviewRequest, String emailId, Long movieId);
	//user

	void deleteMyReviews(Long reviewId);

	ReviewResponse getReviewByReviewId(Long reviewId);

	List<ReviewResponse> getAllReviews();

	List<ReviewResponse> getReviewsByMoviewId(Long movieId);


}
