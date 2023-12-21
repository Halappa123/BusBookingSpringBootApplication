package com.zkteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkteco.dao.BusDao;

public interface BusRepository extends JpaRepository<BusDao, String>{

}
