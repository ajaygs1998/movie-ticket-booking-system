package com.movie.request;

import com.movie.entity.Movie;
import com.movie.entity.User;

import jakarta.validation.constraints.Pattern;
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
public class ReviewRequest {

	
	
	private Long reviewId;
//@Pattern(regexp = "^[1-9]|10$",message = "Rating value should in range 1 to 10. !")
	private Float ratingValue;

	private String comment;

	private User user;

	private Movie movie;
}
