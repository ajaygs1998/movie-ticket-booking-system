//package com.movie.serviceImplementation;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.movie.entity.Theater;
//import com.movie.entity.TheaterLocation;
//import com.movie.repository.TheaterLocationRepository;
//import com.movie.repository.TheaterRepository;
//import com.movie.request.TheaterLocationRequest;
//import com.movie.response.TheaterLocationResponse;
//import com.movie.response.TheaterResponse;
//import com.movie.service.TheaterLocationService;
//
//@Service
//public class TheatreLocatioServiceImplementation implements TheaterLocationService {
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private TheaterLocationRepository theaterLocationRepository;
//
//	@Autowired
//	private TheaterRepository theaterRepository;
//
//	@Override
//	public TheaterLocationResponse addTheaterLocation(TheaterLocationRequest theaterLocationRequest, Long theaterId) {
//
//		Theater theater = this.theaterRepository.findById(theaterId)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//						String.format("Theater with id %d not found", theaterId)));
//		System.out.println(theater.toString());
//		theaterLocationRequest.setTheater(this.modelMapper.map(theater, TheaterResponse.class));
//		TheaterLocation theaterLocation = this.modelMapper.map(theaterLocationRequest, TheaterLocation.class);
//		return modelMapper.map(this.theaterLocationRepository.save(theaterLocation), TheaterLocationResponse.class);
//	}
//
//}
