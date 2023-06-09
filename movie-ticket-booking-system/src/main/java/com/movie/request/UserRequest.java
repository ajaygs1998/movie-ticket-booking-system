package com.movie.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private Long userId;
	
	private String userName;

	private String userMobileNumber;

	private String emailId;

	private String password;
}
