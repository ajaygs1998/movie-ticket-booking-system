package com.movie.service;

import java.util.Set;

import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;

public interface ScreenService {

	ScreenResponse createScreenInTheater(ScreenRequest screenRequest);

	Set<ScreenResponse> getScreenByTheaterId(Long theterId);

}
