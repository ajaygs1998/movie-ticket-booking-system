package com.movie.entity;

import com.movie.enums.SeatType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "seats")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

	@Id
	private int seatId;
	private String seatNumber;

	private String seatStatus;

	@Column(name = "seat_type", nullable = false)
	private SeatType seatType;

	@Column(name = "seat_price", nullable = false)
	private int seatPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screen_id")
	private Screen screen;

}
