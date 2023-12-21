package com.zkteco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.dao.BusDao;
import com.zkteco.dto.ResultEntity;
import com.zkteco.service.BusService;

@RestController
@RequestMapping("/bus-api")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@PostMapping("save_bus")
	public ResponseEntity<ResultEntity> saveBus(@RequestBody BusDao busDao){
		return new ResponseEntity<ResultEntity>(busService.saveBusDetails(busDao),HttpStatus.OK);
	}
	
	@GetMapping("/get_all")
	public ResponseEntity<List<BusDao>> getBusDetails(){
		return new ResponseEntity<List<BusDao>>(busService.findBusDetails(),HttpStatus.OK);
	}
	

}
