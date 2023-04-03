package com.movie.service;

import java.util.List;

import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;

import jakarta.validation.Valid;

public interface SeatService {

	
      SeatResponse addNewSeatsForScreen(SeatRequest seatRequest);

	List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId);

	List<SeatResponse> getAllSeatsInTheater(Long theaterId);
      
       
}
