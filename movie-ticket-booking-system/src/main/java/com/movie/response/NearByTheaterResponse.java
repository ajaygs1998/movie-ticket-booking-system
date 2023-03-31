package com.movie.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NearByTheaterResponse {
	private String distanceFromUser;
	private String TimeToReach;
	private String customMessage;
	private TheaterResponse theaterResponse;
}
