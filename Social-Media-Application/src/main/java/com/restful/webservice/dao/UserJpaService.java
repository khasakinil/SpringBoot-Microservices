package com.restful.webservice.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.bean.UserPosts;
import com.restful.webservice.exception.UserNotFoundException;
import com.restful.webservice.repository.UserPostsRepository;
import com.restful.webservice.repository.UserRepository;

@Service
public class UserJpaService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPostsRepository postRepository;

	public List<UserDetails> findAll() {
		return userRepository.findAll();
	}

	public UserDetails getUser(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}

	public UserDetails saveUser(@Valid UserDetails user) {
		return userRepository.save(user);
	}

	public List<UserPosts> getUserPosts(Integer userId) {

		UserDetails user = userRepository.findByUserId(userId);
		if (user != null) {
			return postRepository.findByUser(user);
		}
		throw new UserNotFoundException("User not found, UserId : " + userId);
	}

	public Optional<UserDetails> getUniqueUser(Integer userId) {
		return userRepository.findByUserIdUnique(userId);
	}

	public List<UserPosts> getUserPostsFromUserDetailsTable(Integer userId) {
		UserDetails user = userRepository.findByUserId(userId);
		if (user != null) {
//			return userRepository.findPostsByUserId(user);
			return user.getPosts();
		}
		throw new UserNotFoundException("User not found, UserId : " + userId);
	}

	public UserPosts createPostForUser(Integer userId, @Valid UserPosts post) {
		Optional<UserDetails> user = userRepository.findByUserIdUnique(userId);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found, UserId : " + userId);
		}

		post.setUser(user.get());
		return postRepository.save(post);

	}

}
