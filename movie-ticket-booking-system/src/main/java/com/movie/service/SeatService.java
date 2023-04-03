package com.movie.service;

import com.movie.request.SeatRequest;
import com.movie.response.SeatRespone;

public interface SeatService {

	
      SeatRespone addNewSeatsForScreen(SeatRequest seatRequest);
      
       
}
