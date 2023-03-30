package com.movie.response;

import com.movie.entity.Screen;
import com.movie.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatRespone {

	private Long seatId;
	private String seatNumber;

	private String seatStatus;

	private SeatType seatType;

	private int seatPrice;

	private Screen screen;
}
