package com.zkteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkteco.dao.UserDao;

public interface UserRepository extends JpaRepository<UserDao, String> {

	UserDao findByEmailAndPassword(String email, String password);

}
