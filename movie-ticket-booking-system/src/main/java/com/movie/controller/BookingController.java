package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.ApiResponse;
import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;
import com.movie.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app/booking/")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping("/create/")
	public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest bookingRequest) {
		BookingResponse createBooking = this.bookingService.createBooking(bookingRequest);
		return new ResponseEntity<BookingResponse>(createBooking, HttpStatus.CREATED);
	}

	@PostMapping("/bookings/showDetails/{showId}/users/{userName}")
	public ResponseEntity<BookingResponse> createBooking(@Valid @PathVariable Long showId, @PathVariable String emailId,
			@RequestBody BookingRequest bookingRequest) {
		BookingResponse createBooking = this.bookingService.createBooking(bookingRequest, showId, emailId);
		return new ResponseEntity<BookingResponse>(createBooking, HttpStatus.CREATED);
	}

	@PutMapping("/update/{bookingId}")
	public ResponseEntity<BookingResponse> updateBooking(@Valid @PathVariable Long bookingId,
			@RequestBody BookingRequest bookingRequest) {
		BookingResponse updatedBooking = this.bookingService.upateBooking(bookingRequest, bookingId);
		return new ResponseEntity<BookingResponse>(updatedBooking, HttpStatus.OK);
	}

	@GetMapping("/search/bookings/{userName}")
	public ResponseEntity<List<BookingResponse>> getAllBookingsForUser(@PathVariable String emailId) {
		List<BookingResponse> serchedbooking = this.bookingService.getAllBookingsForUser(emailId);
		return new ResponseEntity<List<BookingResponse>>(serchedbooking, HttpStatus.OK);
	}

	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<BookingResponse> getBookingByBookingId(@PathVariable Integer bookingId) {
		BookingResponse bookingById = this.bookingService.getBookingByBookingId(bookingId);
		return new ResponseEntity<BookingResponse>(bookingById, HttpStatus.OK);

	}

	@GetMapping("/all/bookings/")
	public ResponseEntity<List<BookingResponse>> getAllBookings() {
		List<BookingResponse> bookings = this.bookingService.getAllBookings();
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<ApiResponse> deleteBooking(@PathVariable Long bookingId) {
		this.bookingService.deleteBooking(bookingId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Booking Deleted Successfully", true), HttpStatus.OK);
	}

}
