package com.movie.response;

import java.util.Set;


import com.movie.entity.Screen;
import com.movie.entity.TheaterLocation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TheaterResponse {

	private Long theaterId;
	
	private String theaterName;

	private TheaterLocation theaterLocation;
	
	private int screenCount;
	
	private Set<Screen> screen;
}
