package com.movie.serviceImplementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.entity.Movie;
import com.movie.entity.Screen;
import com.movie.entity.Theater;
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
	public ScreenResponse createScreenInTheater(ScreenRequest screenRequest, Long theaterId) {
		Screen screen = this.modelMapper.map(screenRequest, Screen.class);
		screen.setScreenName(screenRequest.getScreenName().trim().toUpperCase());
		List<ScreenResponse> existingScreens = getAllScreensInTheater(theaterId);
		existingScreens.stream().filter(i -> i.getScreenName().trim().equalsIgnoreCase(screen.getScreenName()))
				.findAny().ifPresent(n -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(
							"Existing Screen Names:| %s  | . You trying to insert duplicate screen name as : %s",
							existingScreens.stream().map(ScreenResponse::getScreenName)
									.collect(Collectors.joining(", ")),
							screen.getScreenName()));
				});
		if (this.theaterService.getTheaterByTheaterId(theaterId).getScreenCount() <= getAllScreensInTheater(theaterId)
				.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Total allowed screenCount for TheaterId:[%d] are max %d. You cant insert more.",
							theaterId, this.theaterService.getTheaterByTheaterId(theaterId).getScreenCount()));
		}
		screen.setTheater(this.modelMapper.map(this.theaterService.getTheaterByTheaterId(theaterId), Theater.class));
		screen.setShow(Collections.emptyList());   
		Screen savedScreen = this.screenRepository.save(screen);

		return this.modelMapper.map(savedScreen, ScreenResponse.class);
	}

	@Override
	public List<ScreenResponse> getAllScreensInTheater(Long theaterId) {
		TheaterResponse theaterResponse = this.theaterService.getTheaterByTheaterId(theaterId);
		List<Screen> screens = this.screenRepository
				.findByTheater(this.modelMapper.map(theaterResponse, Theater.class));
		// dont uncomment this -> will throw expcetion in createScreen method.
//		if (screens.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//					String.format("Screens with theaterId %d not found", theaterId));
//		}

		List<ScreenResponse> screenResponseList = screens.stream()
				.map(s -> this.modelMapper.map(s, ScreenResponse.class)).collect(Collectors.toList());
		return screenResponseList;
	}

	@Override
	public ScreenResponse updateScreen(ScreenRequest screenRequest, Long theterId, Long screenId) {
		this.getAllScreensInTheater(theterId); // to throw expections if the theater data not found
		Screen screen = this.modelMapper.map(this.getScreenByScreenId(screenId), Screen.class);
		screen.setScreenName(screenRequest.getScreenName());
		screen.setSeatsCapacity(screenRequest.getSeatsCapacity());
		return this.modelMapper.map(screen, ScreenResponse.class);
	}

	

	@Override
	public void deleteScreenByScreenId(Long screenId) {
		this.screenRepository.delete(this.modelMapper.map(this.getScreenByScreenId(screenId), Screen.class));
	}

	@Override
	public ScreenResponse getScreenByScreenId(Long screenId) {
		Screen screen = this.screenRepository.findById(screenId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Screen with id %d not found", screenId)));
		return this.modelMapper.map(screen, ScreenResponse.class);
	}

}
