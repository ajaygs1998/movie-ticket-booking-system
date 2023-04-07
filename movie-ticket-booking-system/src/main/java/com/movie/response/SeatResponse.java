package com.movie.response;

import com.movie.entity.Screen;
import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatResponse {

	private Long seatId;
	
	private String seatNumber;
	
	private String rowNumber;

	@Enumerated(EnumType.STRING)
	private SeatStatus status;

	@Enumerated(EnumType.STRING)
	private SeatType seatType;

	
	private int seatPrice;

	private Screen screen;
}
