package com.rest.services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.services.bean.UserBean;
import com.rest.services.bean.UserDetails;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/web-service")
public class UserInfoController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String userMessage() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-user-bean")
	public UserBean helloUserBean() {
		return new UserBean("bean-message");
	}

	@GetMapping(path = "/hello-user/path-variable/{message}/{user}")
	public UserBean helloUserPathVariable(@PathVariable(name = "message") String message,
			@PathVariable(name = "user") String userName) {
		return new UserBean(message, userName);
	}

	@GetMapping(path = "/msg-user/path-variable/response-entity/{message}/{user}")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user message using @PathVariable")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserBean> userMessagePathVariableResponseEntity(
			@ApiParam(value = "Valid message.<br/>Example:Good morning") @PathVariable(name = "message", required = true) final String message,
			@ApiParam(value = "Valid user name. <br/>Example:Ganesh") @PathVariable(name = "user", required = false) final String userName) {
		return new ResponseEntity<>(new UserBean(message, userName), HttpStatus.OK);
	}

	@GetMapping(path = "/msg-user/request-param/response-entity")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user message using @RequestParam")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserBean> userMessageRequestParamResponseEntity(
			@ApiParam(value = "Valid message.<br/>Example:Good morning") @RequestParam(name = "message", required = true) final String message,
			@ApiParam(value = "Valid user name. <br/>Example:Ganesh") @RequestParam(name = "user", required = false) final String userName) {
		return new ResponseEntity<>(new UserBean(message, userName), HttpStatus.OK);
	}

	@PostMapping(path = "/msg-user/request-body")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user message using @RequestBody")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> userInfoUsingRequestBody(
			@ApiParam(value = "User Details") @RequestBody(required = true) final UserDetails userDetails) {
		return new ResponseEntity<>(new UserDetails(userDetails.getFirstName(), userDetails.getLastName(),
				userDetails.getCity(), userDetails.getPinCode()), HttpStatus.OK);
	}

}
