package com.movie.response;

import com.movie.entity.Movie;
import com.movie.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewResponse {

	private Long reviewId;

	private Float ratingValue;

	private String comment;

	private User user;

	private Movie movie;
}
