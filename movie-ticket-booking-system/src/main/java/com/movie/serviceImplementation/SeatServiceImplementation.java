package com.movie.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.movie.entity.Seat;
import com.movie.repository.SeatRepository;
import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;
import com.movie.service.SeatService;

import jakarta.validation.Valid;
@Service
public class SeatServiceImplementation implements SeatService {

	@Override
	public SeatResponse addNewSeatsForScreen(SeatRequest seatRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeatResponse> getAllSeatsInTheater(Long theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
