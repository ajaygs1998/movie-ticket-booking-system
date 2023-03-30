package com.movie.request;

import com.movie.entity.Movie;
import com.movie.entity.User;

public class ReviewRequest {

	
	
	private Long reviewId;

	private Float ratingValue;

	private String comment;

	private User user;

	private Movie movie;
}
