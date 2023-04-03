package com.movie.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.entity.Screen;
import com.movie.entity.Theater;
import com.movie.exception.ResourceNotFoundException;
import com.movie.repository.ScreenRepository;
import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;
import com.movie.response.TheaterResponse;
import com.movie.service.ScreenService;
import com.movie.service.TheaterService;

@Service
public class SreeenServiceImplementation implements ScreenService {

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ScreenResponse> createScreenInTheater(List<ScreenRequest> screenRequest, Long theaterId) {
		TheaterResponse theaterResponse = this.theaterService.getTheaterByTheaterId(theaterId);
		
		theaterResponse.getScreenCount();
		theaterResponse.getScreenCount();
		//
		List<Screen> screenList = screenRequest.stream().map(source -> this.modelMapper.map(source, Screen.class))
				.collect(Collectors.toList());
		
		Theater theater = this.modelMapper.map(theaterResponse, Theater.class);
		for (Screen i : screenList) {
			i.setTheater(theater);
		}
		List<Screen> savedScreenList = this.screenRepository.saveAll(screenList);
		System.out.println(savedScreenList);
		return savedScreenList.stream().map(source -> this.modelMapper.map(source, ScreenResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ScreenResponse> getAllScreensInTheater(Long theaterId) {
		TheaterResponse theaterResponse = this.theaterService.getTheaterByTheaterId(theaterId);
		List<Screen> screens = this.screenRepository
				.findByTheater(this.modelMapper.map(theaterResponse, Theater.class));
		if (screens.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Screens with theaterId %d not found", theaterId));
		}
		return screens.stream().map(source -> this.modelMapper.map(source, ScreenResponse.class))
				.collect(Collectors.toList());

	}

	@Override
	public ScreenResponse updateScreens(ScreenRequest screenRequest, Long theterId, Long screenId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScreenResponse> getAllScreensInAllTheaters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteScreenByScreenId(Integer movieId) {
		// TODO Auto-generated method stub

	}

}
