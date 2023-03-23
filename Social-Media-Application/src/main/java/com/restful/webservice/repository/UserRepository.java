package com.restful.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservice.bean.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByUserId(Integer userId);

}
