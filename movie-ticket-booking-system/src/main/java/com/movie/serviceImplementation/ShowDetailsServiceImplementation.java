package com.movie.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.request.ShowDetailsRequest;
import com.movie.response.CustomResponse;
import com.movie.response.ShowDetailsResponse;
import com.movie.service.ShowDetailsService;

import jakarta.validation.Valid;
@Service
public class ShowDetailsServiceImplementation implements ShowDetailsService{

	@Override
	public ShowDetailsResponse createShowDetails(@Valid ShowDetailsRequest showDetailsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResponse createShowDetails(ShowDetailsResponse showDetailsRequest, @Valid Long movieId,
			Long theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowDetailsResponse getShowDetailsByShowDetailsId(Long showDetailsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowDetailsResponse> getAllShowDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteShowDetails(Long showDetailsId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShowDetailsResponse upateShowDetails(ShowDetailsResponse showDetailsRequest, @Valid Long showDetailsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowDetailsResponse> getShowDetailsByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
