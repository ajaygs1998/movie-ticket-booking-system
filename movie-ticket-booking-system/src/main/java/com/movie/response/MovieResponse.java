package com.movie.response;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.movie.entity.Review;
import com.movie.entity.ShowDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * what is expected in the movie response to the user
 *  movie name
 *  language,
 *  ticket base price
 *    genre
 *    
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {

	private Long movieId;

	private String movieName;

	private LocalDate releaseDate;

	private Integer duration;

	private String description;

	private String genre;

	private List<ShowDetails> showDetails;
	private List<Review> review;

}
