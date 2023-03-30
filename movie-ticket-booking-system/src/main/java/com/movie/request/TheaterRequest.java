package com.movie.request;

import java.util.Set;

import com.movie.response.ScreenResponse;

import jakarta.validation.constraints.NotBlank;
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

	private Long theaterId;
	@NotBlank(message = "Theater name should not be blank")
	private String theaterName;
	private int screenCount;

	private String street;
	private String city;
	private String state;
	private String zip;

	private double longitude; // vertical lines
	private double latitude; // horizontal lines
	private Set<ScreenResponse> screen;

}
