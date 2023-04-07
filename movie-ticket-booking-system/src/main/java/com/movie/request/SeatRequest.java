package com.movie.request;

import com.movie.entity.Screen;
import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SeatRequest {

	private Long seatId;
	@Positive //0 is invalid..
	@NotNull
	private String seatNumber;
	@NotBlank
	private Character rowName;

	@Enumerated(EnumType.STRING)
	private SeatStatus status;

	@Enumerated(EnumType.STRING)
	private SeatType seatType;

	@Positive
	@NotNull
	private int seatPrice;

	private Screen screen;
}
