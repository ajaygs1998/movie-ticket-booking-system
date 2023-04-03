package com.movie.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;
import com.movie.service.MovieService;

import jakarta.validation.Valid;

@Service
public class MovieServiceImplementation implements MovieService {

	@Override
	public MovieResponse createMovie(@Valid MovieRequest movieResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieResponse upateMovie(MovieRequest movieRequest, @Valid Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieResponse> getMovieByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieResponse getMovieByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieResponse> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(Long movieId) {
		// TODO Auto-generated method stub
		
	}

}
