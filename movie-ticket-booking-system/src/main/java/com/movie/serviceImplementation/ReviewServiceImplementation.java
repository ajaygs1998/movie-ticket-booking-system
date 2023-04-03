package com.movie.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.request.MovieRequest;
import com.movie.request.ReviewRequest;
import com.movie.response.MovieResponse;
import com.movie.response.ReviewResponse;
import com.movie.service.MovieService;
import com.movie.service.ReviewService;

import jakarta.validation.Valid;
@Service
public class ReviewServiceImplementation implements ReviewService {

	@Override
	public ReviewResponse createReview(@Valid ReviewRequest reviewRequest, String emailId, Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMyReviews(Long reviewId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReviewResponse getReviewByReviewId(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewResponse> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewResponse> getReviewsByMoviewId(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
