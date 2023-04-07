package com.movie.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

	public ResourceNotFoundException(HttpStatus notFound, String format) {
		// TODO Auto-generated constructor stub
	}
}
