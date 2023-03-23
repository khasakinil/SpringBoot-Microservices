package com.restful.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.bean.UserPosts;

public interface UserPostsRepository extends JpaRepository<UserPosts, Integer> {
	List<UserPosts> findByUser(UserDetails user);
}
