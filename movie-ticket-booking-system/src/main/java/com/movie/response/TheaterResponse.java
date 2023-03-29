package com.movie.response;

import java.util.Set;

import com.movie.entity.Screen;
import com.movie.entity.TheaterLocation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TheaterResponse {

	private Long theatreId;
	
	private String theaterName;
	
	private TheaterLocation theaterLocation;
	
	private int screenCount;
	
	private Set<Screen> screen;
}
