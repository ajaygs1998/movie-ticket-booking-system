package com.movie.request;

import java.util.List;

import com.movie.entity.Seat;
import com.movie.entity.ShowDetails;
import com.movie.entity.Theater;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreenRequest {

	private long screenId;

	private String screenName;

	private Long seatsCapacity;

	private List<ShowDetails> show;

	private Theater theater;

	private List<Seat> seat;
}
