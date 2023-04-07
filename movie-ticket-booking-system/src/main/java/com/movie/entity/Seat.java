package com.movie.entity;

import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;

	@Column(name = "seat_number")
	private String seatNumber;

	@Column(name = "row_name")
	private Character rowName;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private SeatStatus status;

	@Column(name = "seat_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private SeatType seatType;

	@Column(name = "seat_price", nullable = false)
	@Positive
	@NotNull
	private int seatPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screen_id")
	private Screen screen;

}
