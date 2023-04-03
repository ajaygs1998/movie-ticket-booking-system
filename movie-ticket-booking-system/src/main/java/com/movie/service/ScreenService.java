package com.movie.service;

import java.util.List;

import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;

public interface ScreenService {

	
	//super-admin
	List<ScreenResponse> createScreenInTheater(List<ScreenRequest> screenRequest, Long TheaterId);
  
	//user/amdin/superaddmin
	List<ScreenResponse> getAllScreensInTheater(Long theterId);

    //admin
	ScreenResponse updateScreens(ScreenRequest screenRequest, Long theterId, Long screenId);


	//super-admin for testing:
	List<ScreenResponse> getAllScreensInAllTheaters();

	//superadmin/ admin   
	void deleteScreenByScreenId(Integer movieId);
	
	


	
}
