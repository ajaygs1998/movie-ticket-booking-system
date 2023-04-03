package com.movie.serviceImplementation;

import java.util.List;

import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;
import com.movie.service.BookingService;

import jakarta.validation.Valid;

public class BookingServiceImplementation implements BookingService {

	@Override
	public BookingResponse createBooking(@Valid BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponse createBooking(BookingRequest bookingRequest, @Valid Long showId, String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponse upateBooking(BookingRequest bookingRequest, @Valid Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingResponse> getAllBookingsForUser(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponse getBookingByBookingId(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingResponse> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Long bookingId) {
		// TODO Auto-generated method stub

	}

}
