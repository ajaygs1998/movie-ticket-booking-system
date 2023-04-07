package com.movie.response;

import java.util.Set;

import com.movie.entity.Screen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class TheaterResponse {
	private Long theaterId;
	private String theaterName;
	private int screenCount;

	private String street;
	private String city;
	private String state;
	private String zip;

	private double longitude; // vertical lines
	private double latitude; // horizontal lines
	private Set<Screen> screen;
	
	
}
