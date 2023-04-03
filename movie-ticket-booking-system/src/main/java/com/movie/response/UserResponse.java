package com.movie.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private Long userId;
	private String userName;

	private String userMobileNumber;

	private String emailId;

	private String password;

}
