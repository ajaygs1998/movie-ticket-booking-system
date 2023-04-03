package com.movie.service;

import java.util.List;

import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;

import jakarta.validation.Valid;

public interface BookingService {

	BookingResponse createBooking(@Valid BookingRequest bookingRequest);

	BookingResponse createBooking(BookingRequest bookingRequest, @Valid Long showId, String emailId);

	BookingResponse upateBooking(BookingRequest bookingRequest, @Valid Long bookingId);

	List<BookingResponse> getAllBookingsForUser(String emailId);

	BookingResponse getBookingByBookingId(Integer bookingId);

	List<BookingResponse> getAllBookings();

	void deleteBooking(Long bookingId);
	


}
