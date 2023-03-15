package com.restful.webservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.dao.UserDaoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDaoService service;

	public UserController(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/all")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get all the users")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> getUser(
			@ApiParam(value = "Valid userId. <br/>Example:101") @PathVariable(name = "id", required = true) Integer userId) {
		return new ResponseEntity<>(service.getUser(userId), HttpStatus.OK);
	}

	@PostMapping(path = "/users")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "create user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> createUser(
			@ApiParam(value = "Valid user object") @RequestBody(required = true) UserDetails user) {
		UserDetails createUser = service.createUser(user);
//		return new ResponseEntity<>(createUser, HttpStatus.OK);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

//	@ApiParam(value = "Valid userId. <br/>Example:101") @RequestParam(required = false) final Integer userId,
//	@ApiParam(value = "Valid user name. <br/>Example:Ganesh") @RequestParam(required = true) final String userName,
//	@ApiParam(value = "Valid user DOB. <br/>Example:2nd June 1992") @RequestParam(required = false) final LocalDate dob

}
