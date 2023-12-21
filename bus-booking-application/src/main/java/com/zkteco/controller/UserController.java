package com.zkteco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.dao.BusDao;
import com.zkteco.dto.ResultEntity;
import com.zkteco.dto.UserDto;
import com.zkteco.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user-api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registry") 
	public ResponseEntity<ResultEntity> userRegistry(@RequestBody UserDto userDto){
		return new ResponseEntity<ResultEntity>(userService.registerUser(userDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<Flux<ResultEntity>> loginUser(@PathVariable String email,@PathVariable String password){
		return new ResponseEntity<Flux<ResultEntity>>(userService.loginUser(email,password),HttpStatus.ACCEPTED);
	}
	
	

}
