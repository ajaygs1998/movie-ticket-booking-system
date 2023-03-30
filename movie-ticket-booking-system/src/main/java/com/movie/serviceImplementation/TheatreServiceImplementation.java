package com.movie.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movie.entity.Theater;
import com.movie.repository.TheaterRepository;
import com.movie.request.TheaterRequest;
import com.movie.response.NearByTheaterResponse;
import com.movie.response.TheaterResponse;
import com.movie.service.TheaterService;

@Service
public class TheatreServiceImplementation implements TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TheaterResponse createTheater(TheaterRequest theaterRequest) {
		Theater theater = modelMapper.map(theaterRequest, Theater.class);
		Theater savedTheater = theaterRepository.save(theater);
		return modelMapper.map(savedTheater, TheaterResponse.class);
	}

	@Override
	public List<NearByTheaterResponse> getNearByTheater(Double latitude, Double longitude, Double radius) {
		NearByTheaterResponse nearByTheaterResponse = new NearByTheaterResponse();
		List<TheaterResponse> theaterResponse = this.theaterRepository.findAll().stream()
				.map(source -> this.modelMapper.map(source, TheaterResponse.class)).toList();
		double radiusInKm = radius * 1000;
		List<NearByTheaterResponse> nearByTheaterResponseList = new ArrayList<>();

		for (TheaterResponse resposne : theaterResponse) {
			double theaterDistanceFromUser = distance(latitude, longitude, resposne.getLatitude(),
					resposne.getLongitude());
			System.out.println("Distance from me:" + theaterDistanceFromUser);
			if (theaterDistanceFromUser <= radiusInKm) {
				nearByTheaterResponse.setCustomMessage("Future scope: 'On going movie(movie name from this theater)' just 'time(in mins ex. 7 mins.)' away from you");
				// Rounding distance till 1 precision then converting into String with km as
				// unit
				StringBuilder dis = new StringBuilder(Double.toString(Math.round(theaterDistanceFromUser * 10) / 10));
				dis.append(" km");
				/*
				 * String to StringBuilder using append() method StringBuilder to String
				 * usingtoString() method
				 */
				nearByTheaterResponse.setDistanceFromUser(dis.toString());
				nearByTheaterResponse.setTheterResponse(resposne);
				nearByTheaterResponseList.add(nearByTheaterResponse);
			}

		}

		return nearByTheaterResponseList;
	}

	@Override
	public TheaterResponse getTheaterByTheaterId(Long theaterId) {
		Theater theater = this.theaterRepository.findById(theaterId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Theater with id %d not found", theaterId)));
		return this.modelMapper.map(theater, TheaterResponse.class);
	}

	@Override
	public List<TheaterResponse> getTheaterByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	// helper method to calulate the distance
	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371; // Radius of the earth in km
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c; // Distance in km
		return d;
	}

}
