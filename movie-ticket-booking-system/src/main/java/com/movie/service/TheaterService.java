package com.movie.service;

import java.util.List;
import java.util.Set;

import com.movie.entity.Theater;
import com.movie.request.TheaterRequest;
import com.movie.response.NearByTheaterResponse;
import com.movie.response.TheaterResponse;

public interface TheaterService {

	TheaterResponse createTheater(TheaterRequest theaterResponse);

	List<TheaterResponse> getTheaterByKeyword(String keyword);
	
	

	TheaterResponse getTheaterByTheaterId(Long theaterId);

	

	List<NearByTheaterResponse> getNearByTheater(Double latitude, Double longitude, Double radius
			);

	

}
