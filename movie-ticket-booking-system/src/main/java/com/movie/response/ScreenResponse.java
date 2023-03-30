package com.movie.response;

import java.time.LocalDate;
import java.util.List;

import com.movie.entity.Review;
import com.movie.entity.ShowDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreenResponse {

	
	
	private Long movieId;

	private String movieName;

	private LocalDate releaseDate;

	private Integer duration;

	private String description;

	private String genre;

	private List<ShowDetails> showDetails;
	private List<Review> review;
}
