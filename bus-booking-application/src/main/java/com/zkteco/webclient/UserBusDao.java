package com.zkteco.webclient;

import com.zkteco.dao.BusDao;
import com.zkteco.dao.UserDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBusDao {
	
	private UserDao userDao;
	private BusDao busDao;

}
