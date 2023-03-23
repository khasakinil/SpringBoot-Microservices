package com.restful.webservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.bean.UserPosts;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByUserId(Integer userId);

	@Query("SELECT u FROM UserDetails u WHERE u.userId=:userId")
	Optional<UserDetails> findByUserIdUnique(Integer userId);

	List<UserPosts> findPostsByUserId(UserDetails user);
}
