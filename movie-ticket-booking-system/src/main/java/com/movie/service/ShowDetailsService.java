package com.movie.service;

import java.util.List;

import com.movie.request.ShowDetailsRequest;
import com.movie.response.CustomResponse;
import com.movie.response.ShowDetailsResponse;

import jakarta.validation.Valid;

public interface ShowDetailsService {

	ShowDetailsResponse createShowDetails(@Valid ShowDetailsRequest showDetailsRequest);

	CustomResponse createShowDetails(ShowDetailsResponse showDetailsRequest, @Valid Long movieId, Long theaterId);

	ShowDetailsResponse getShowDetailsByShowDetailsId(Long showDetailsId);

	List<ShowDetailsResponse> getAllShowDetails();

	void deleteShowDetails(Long showDetailsId);

	ShowDetailsResponse upateShowDetails(ShowDetailsResponse showDetailsRequest, @Valid Long showDetailsId);

	List<ShowDetailsResponse> getShowDetailsByMovieId(Long movieId);



}
