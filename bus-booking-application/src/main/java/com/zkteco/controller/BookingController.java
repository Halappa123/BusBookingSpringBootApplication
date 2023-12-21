package com.zkteco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.dto.ResultEntity;
import com.zkteco.service.BookingService;

@RestController
@RequestMapping("/booking-api")
public class BookingController {
	
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/book_bus")
	public ResponseEntity<ResultEntity> bookBus(@PathVariable String userId,@PathVariable String origin,@PathVariable String destination,@PathVariable String departureDateTime){
		return null;
		
	}

}
