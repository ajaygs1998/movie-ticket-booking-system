package com.movie.serviceImplementation;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.entity.Theater;
import com.movie.repository.TheaterRepository;
import com.movie.request.TheaterRequest;
import com.movie.response.TheaterResponse;
import com.movie.service.TheaterService;

@Service
public class TheatreServiceImplementation implements TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TheaterResponse createTheater(TheaterRequest theaterRequest) {
		Theater theater = modelMapper.map(theaterRequest, Theater.class);
		Theater savedTheater = theaterRepository.save(theater);
		return modelMapper.map(savedTheater, TheaterResponse.class);
	}
	
	
	@Override
	public TheaterResponse getTheaterByTheaterId(Long theaterId) {
		Theater theater = this.theaterRepository.findById(theaterId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Theater with id %d not found", theaterId)));
		return this.modelMapper.map(theater, TheaterResponse.class);	}


	@Override
	public List<TheaterResponse> getTheaterByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TheaterResponse> searchNearByTheater(TheaterRequest theaterRequest) {
		// TODO Auto-generated method stub
		return null;
	}


}
