package com.zkteco.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.zkteco.dao.BusDao;
import com.zkteco.dao.UserDao;
import com.zkteco.dto.ResultEntity;
import com.zkteco.dto.UserDto;
import com.zkteco.repository.UserRepository;
import com.zkteco.service.UserService;
import com.zkteco.webclient.UserBusDao;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Configuration
@Service
//@Slf4j
public class UserServiceImpl implements UserService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	
    private final String baseUrl="http://localhost:9090/bus-api";
    
	@Autowired
	private UserRepository userRepository;
	
	
//  @Autowired 
//  private BCryptPasswordEncoder passwordEncoder;
	 

	@Override
	public ResultEntity registerUser(UserDto userDto) {
		UserDao dao=new UserDao();
		
		
//		String password = userDto.getPassword();
//		String hashedPassword = passwordEncoder().encode(password);                                           
//		userDto.setPassword(hashedPassword);
//		String password=userDto.getPassword(); 

		BeanUtils.copyProperties(userDto, dao);
		
		userRepository.save(dao);
		 
		return new ResultEntity("User Registred successfully", dao);
	}

	@Override
	public Flux<ResultEntity> loginUser(String email, String password) {
		UserDao user = userRepository.findByEmailAndPassword(email, password);

		if (user == null) {
		    logger.info("Email and password are incorrect ! {} ");
		 //   return new ResultEntity("User email and password not found", null);
		}

		logger.info("User logged in: {}", user);

		WebClient webClient = WebClient.create(baseUrl);
		Flux<BusDao> busDetails = webClient.get()
		        .uri("/get_all")
		        .accept(MediaType.APPLICATION_JSON)
		        .retrieve()
	            .bodyToFlux(BusDao.class);
		
		logger.info("login successful and available busses are {} :", busDetails);
		
		// one way to return data with message
		return Flux.just(busDetails)
	            .flatMap(u -> busDetails.map(bus -> {
	                // Process bus details and assemble ResultEntity
	                String message = "Login successful! Available Bus are : ";    
	                return new ResultEntity(message , bus);
	            }))
	            .switchIfEmpty(Flux.just(new ResultEntity("Login successful, but no Bus data found", null)));
		}
		       
		  
	}
	
	 

	
