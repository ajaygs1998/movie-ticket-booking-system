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
import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;
import com.movie.service.MovieService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app/movie/")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/movies/")
	public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody MovieRequest MovieResponse) {
		MovieResponse createMovie = this.movieService.createMovie(MovieResponse);
		return new ResponseEntity<MovieResponse>(createMovie, HttpStatus.CREATED);
	}

	@PutMapping("/movies/{movieId}")
	public ResponseEntity<MovieResponse> updateMovie(@Valid @PathVariable Long movieId,
			@RequestBody MovieRequest movieRequest) {
		MovieResponse updatedMovie = this.movieService.upateMovie(movieRequest, movieId);
		return new ResponseEntity<MovieResponse>(updatedMovie, HttpStatus.OK);
	}

	@GetMapping("/search/movies/{keyword}")
	public ResponseEntity<?> getMovieByKeyword(@PathVariable String keyword) {
		List<MovieResponse> serchedmovie = this.movieService.getMovieByKeyword(keyword);
		return new ResponseEntity<>((!serchedmovie.isEmpty()) ? serchedmovie
				: new ApiResponse("Movie not found with keyword: " + keyword, true), HttpStatus.OK);
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieResponse> getMovieByMovieId(@PathVariable Long movieId) {
		MovieResponse movieById = this.movieService.getMovieByMovieId(movieId);
		return new ResponseEntity<MovieResponse>(movieById, HttpStatus.OK);
	}

	@GetMapping("/movies/")
	public ResponseEntity<?> getAllMovies() {
		List<MovieResponse> movies = this.movieService.getAllMovies();
		return new ResponseEntity<>((!movies.isEmpty()) ? movies : new ApiResponse("Movie list is empty ", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<ApiResponse> deleteMovie(@PathVariable Long movieId) {
		this.movieService.deleteMovie(movieId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Movie Deleted Successfully", true), HttpStatus.OK);
	}
}
