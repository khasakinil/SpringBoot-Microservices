package com.restful.webservice.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.repository.UserRepository;

@Service
public class UserJpaService {

	@Autowired
	private UserRepository repository;

	public List<UserDetails> findAll() {
		return repository.findAll();
	}

	public UserDetails getUser(Integer userId) {
		return repository.findByUserId(userId);
	}

	public void deleteUserById(Integer userId) {
		repository.deleteById(userId);
	}

	public UserDetails saveUser(@Valid UserDetails user) {
		return repository.save(user);
	}

}
