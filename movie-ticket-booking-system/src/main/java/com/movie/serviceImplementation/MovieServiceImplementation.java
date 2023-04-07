package com.movie.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;
import com.movie.service.MovieService;

import jakarta.validation.Valid;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MovieResponse createMovie(@Valid MovieRequest movieRequest) {
		return this.modelMapper.map(this.movieRepository.save(this.modelMapper.map(movieRequest, Movie.class)),
				MovieResponse.class);
	}

	@Override
	public MovieResponse getMovieByMovieId(Long movieId) {
		Movie movie = this.movieRepository.findById(movieId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Movie with id %d not found", movieId)));
		
		return this.modelMapper.map(movie, MovieResponse.class);
	}

	@Override
	public MovieResponse upateMovie(MovieRequest movieRequest, @Valid Long movieId) {
		MovieResponse movieResponse = this.getMovieByMovieId(movieId);
		movieResponse.setMovieName(movieRequest.getMovieName());
		movieResponse.setReleaseDate(movieRequest.getReleaseDate());
		movieResponse.setDescription(movieRequest.getDescription());
		movieResponse.setDuration(movieRequest.getDuration());
		movieResponse.setGenre(movieRequest.getGenre());
		Movie updatedMovie = this.movieRepository.save(this.modelMapper.map(movieResponse, Movie.class));
		return this.modelMapper.map(updatedMovie, MovieResponse.class);
	}

	@Override
	public List<MovieResponse> getMovieByKeyword(String keyword) {
		return this.movieRepository.findByKeyword(keyword).stream()
				.map(source -> this.modelMapper.map(source, MovieResponse.class)).collect(Collectors.toList());
	}

	@Override
	public List<MovieResponse> getAllMovies() {
		return this.movieRepository.findAll().stream().map(e -> this.modelMapper.map(e, MovieResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteMovie(Long movieId) {
		this.movieRepository.delete(this.modelMapper.map(this.getMovieByMovieId(movieId), Movie.class));
	}

}
