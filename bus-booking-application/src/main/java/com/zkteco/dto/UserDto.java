package com.zkteco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phNo;
	private String password;

}
