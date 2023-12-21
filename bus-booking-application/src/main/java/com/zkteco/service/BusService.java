package com.zkteco.service;

import java.util.List;

import com.zkteco.dao.BusDao;
import com.zkteco.dto.ResultEntity;

import reactor.core.publisher.Flux;

public interface BusService {

	ResultEntity saveBusDetails(BusDao busDao);

	List<BusDao> findBusDetails();

	

}
