package com.zkteco.service;

import com.zkteco.dto.ResultEntity;
import com.zkteco.dto.UserDto;

import reactor.core.publisher.Flux;

public interface UserService {

	ResultEntity registerUser(UserDto userDto);

	Flux<ResultEntity> loginUser(String email, String password);


}
