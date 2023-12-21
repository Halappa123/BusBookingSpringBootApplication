package com.zkteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkteco.dao.BookingDao;

public interface BookingRepository extends JpaRepository<BookingDao, String> {

}
