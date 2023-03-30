package com.movie.request;

import com.movie.entity.Screen;
import com.movie.enums.SeatType;

public class SeatRequest {

	private Long seatId;
	private String seatNumber;

	private String seatStatus;

	
	private SeatType seatType;

	
	private int seatPrice;

	
	private Screen screen;
}
