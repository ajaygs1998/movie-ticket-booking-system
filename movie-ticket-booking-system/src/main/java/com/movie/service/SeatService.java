//package com.movie.service;
//
//import java.util.List;
//
//import com.movie.request.SeatRequest;
//import com.movie.response.SeatResponse;
//
//import jakarta.validation.Valid;
//
//public interface SeatService {
//
//    
//	List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId, Long screenId);
//
//	List<SeatResponse> getAllSeatsInSpecificScreen(Long theaterId);
//
//	SeatResponse updateSeatsInSpecificScreen(SeatRequest seatRequest, Long theaterId, Long ScreenId);
//
//	void seatsForSpecificScreen(Long theaterId, Long screenId);
//	
//	SeatResponse getSeatBySeatId(Long SeatId);
//	
//	
//
//}
