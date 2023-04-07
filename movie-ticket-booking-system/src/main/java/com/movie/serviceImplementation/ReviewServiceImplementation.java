package com.movie.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.configurations.ErrorMessages;
import com.movie.configurations.SystemConstants;
import com.movie.entity.Movie;
import com.movie.entity.Review;
import com.movie.entity.User;
import com.movie.repository.MovieRepository;
import com.movie.repository.ReviewRepository;
import com.movie.repository.UserRepository;
import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;
import com.movie.service.ReviewService;

import jakarta.validation.Valid;

@Service
public class ReviewServiceImplementation implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReviewResponse createReview(@Valid ReviewRequest reviewRequest, Long userId, Long movieId) {
		if (reviewRequest.getRatingValue() < SystemConstants.MIN_RATING
				|| reviewRequest.getRatingValue() > SystemConstants.MAX_RATING) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(ErrorMessages.VALID_RATING_RANGE,
					SystemConstants.MIN_RATING, SystemConstants.MAX_RATING));
		}

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("User with id %d not found", userId)));

		Movie movie = this.movieRepository.findById(movieId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Movie with id %d not found", movieId)));

		Review review = this.modelMapper.map(reviewRequest, Review.class);
		review.setUser(user);
		review.setMovie(movie);
		review.setRatingValue((Math.round(reviewRequest.getRatingValue() * 10) / 10.0f));
		return this.modelMapper.map(this.reviewRepository.save(review), ReviewResponse.class);
	}

	@Override
	public ReviewResponse getReviewByReviewId(Long reviewId) {
		return this.modelMapper.map(this.reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Review with id %d not found", reviewId))),
				ReviewResponse.class);
	}

	@Override
	public List<ReviewResponse> getAllReviews() {
		return this.reviewRepository.findAll().stream().map(s -> this.modelMapper.map(s, ReviewResponse.class))
				.collect(Collectors.toList());

	}

	@Override
	public List<ReviewResponse> getReviewsByMovieId(Long movieId) {
		Movie movie = this.movieRepository.findById(movieId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Movie with id %d not found", movieId)));

		return this.reviewRepository.findByMovie(movie).stream().map(s -> this.modelMapper.map(s, ReviewResponse.class))
				.collect(Collectors.toList());
	}

}
