package com.movie.request;

import java.time.LocalDate;
import java.util.List;

import com.movie.entity.Review;
import com.movie.entity.Screen;
import com.movie.entity.ShowDetails;
import com.movie.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

	
	private Long movieId;

	private String movieName;

	private LocalDate releaseDate;

	private Integer duration;

	private String description;

	private String genre;

	private List<ShowDetails> showDetails;
	private List<Review> review;
}
