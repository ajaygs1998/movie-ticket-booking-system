package com.movie.service;

import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;



public interface MovieService {

	//create-movie-admin
MovieResponse addNewMovie(MovieRequest movieRequest);


}
