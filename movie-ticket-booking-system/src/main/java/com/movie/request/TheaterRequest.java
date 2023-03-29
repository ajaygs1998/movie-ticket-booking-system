package com.movie.request;

import java.util.Set;

import com.movie.entity.Screen;
import com.movie.entity.TheaterLocation;
import com.movie.response.ScreenResponse;
import com.movie.response.TheaterLocationResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Request class for Theater.
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheaterRequest {

	//private Long theatreId;
	@NotBlank(message = "Theater name should not be blank")
	private String theaterName;
	//@NotBlank(message = "Theatre Location should not be blank")
	private TheaterLocationResponse theaterLocation;
	@NotNull(message = "Screen count can't be null")
	private int screenCount;
	
	private Set<ScreenResponse> screen;

}
