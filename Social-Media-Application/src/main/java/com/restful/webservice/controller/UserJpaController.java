package com.restful.webservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.bean.UserPosts;
import com.restful.webservice.dao.UserJpaService;
import com.restful.webservice.exception.UserNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserJpaController {

	@Autowired
	private UserJpaService service;

	public UserJpaController(UserJpaService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/jpa/all")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get all the users")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/jpa/{id}")
	@ApiOperation(produces = MediaType.APPLICATION_XML_VALUE, value = "Get user by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> getUser(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId) {
		UserDetails user = service.getUser(userId);

		if (user == null) {
			throw new UserNotFoundException("id:" + userId);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	@PostMapping(path = "/jpa/users")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "create user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> createUser(
			@Valid @ApiParam(value = "Valid user object") @RequestBody(required = true) UserDetails user) {
		UserDetails createUser = service.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/{id}")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Delete user by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public void deleteUser(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId) {
		service.deleteUserById(userId);

	}

	@GetMapping(path = "/user/{id}")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> getUniqueUser(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId) {
		Optional<UserDetails> user = service.getUniqueUser(userId);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found, UserId:" + userId);
		} else {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "get post by user id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public List<UserPosts> listUserPosts(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId) {
//		return service.getUserPosts(userId);
		return service.getUserPostsFromUserDetailsTable(userId);
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "create post for user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<Object> createPostForUser(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId,
			@Valid @RequestBody UserPosts post) {

		UserPosts userPost = service.createPostForUser(userId, post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
