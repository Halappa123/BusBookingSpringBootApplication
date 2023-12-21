package com.zkteco.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.dao.BusDao;
import com.zkteco.dto.ResultEntity;
import com.zkteco.repository.BusRepository;
import com.zkteco.service.BusService;
import com.zkteco.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusServiceImpl implements BusService {
	
    private static final Logger logger = LoggerFactory.getLogger(BusService.class);
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public ResultEntity saveBusDetails(BusDao busDao) {
		
		BusDao busDao1=new BusDao();
		BeanUtils.copyProperties(busDao, busDao1);
		busRepository.save(busDao1);
		log.info("Bus details are {} :", busDao1);
		return new ResultEntity("Bus Details are saved successfully", busDao1);
		}

	@Override
	public List<BusDao> findBusDetails() {
		
		List<BusDao> exists =busRepository.findAll();
	//	ResultEntity entity=new ResultEntity();
		
		if(exists.isEmpty() || exists==null) {
			logger.info("failed to fetch details {} :");
			return null;
		}
		logger.info("bus details are fetched successfully ", exists);
		return exists;
	
	}

	

}
