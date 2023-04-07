//package com.movie.serviceImplementation;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.xml.transform.Source;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.movie.entity.Screen;
//import com.movie.entity.Seat;
//import com.movie.entity.Theater;
//import com.movie.repository.ScreenRepository;
//import com.movie.repository.SeatRepository;
//import com.movie.repository.TheaterRepository;
//import com.movie.request.SeatRequest;
//import com.movie.response.SeatResponse;
//import com.movie.service.SeatService;
//
//import jakarta.validation.Valid;
//
//@Service
//public class SeatServiceImplementation implements SeatService {
//	@Autowired
//	private SeatRepository seatRepository;
//
//	@Autowired
//	private TheaterRepository theaterRepository;
//
//	@Autowired
//	private ScreenRepository screenRepository;
//
//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId, Long screenId) {
//		Theater theater = this.theaterRepository.findById(theaterId)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//						String.format("Theater with id %d not found", theaterId)));
//
//		Screen screen = this.screenRepository.findById(screenId)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//						String.format("Screen with id %d not found", screenId)));
//
//		seatRequest.forEach(seat -> seat.setScreen(screen));
//		// do the validation for seats;
//		// here
//
//		List<Seat> seatList = seatRequest.stream().map(source -> this.modelMapper.map(source, Seat.class))
//				.collect(Collectors.toList());
//		List<Seat> savedSeats = seatRepository.saveAll(seatList);
//
//		return savedSeats.stream().map(source -> this.modelMapper.map(source, SeatResponse.class))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public List<SeatResponse> getAllSeatsInSpecificScreen(Long theaterId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public SeatResponse updateSeatsInSpecificScreen(SeatRequest seatRequest, Long theaterId, Long ScreenId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void seatsForSpecificScreen(Long theaterId, Long screenId) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public SeatResponse getSeatBySeatId(Long SeatId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
