package com.movie.service;

import java.util.List;
import java.util.TreeSet;


import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;

public interface ReviewService {
	//user
	ReviewResponse doRatingForMovie(ReviewRequest ReviewRequest, String userName, Long movieId);

	//user
	void deleteMyReviews(Long userId);

	//for testing
	List<ReviewResponse> getAllRatings();
 
	
	//for testing 
	ReviewResponse getRatingByRatingId(Integer ratingId);

	//with movies
	List<ReviewResponse> getRatingByMovieId(Integer movieId);

}
