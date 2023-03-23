package com.restful.webservice.controller;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservice.bean.UserDetails;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/social-media")
public class SocialMediaApplicationController {

	private MessageSource messageSource;

	public SocialMediaApplicationController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/user/info/requestparam")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user details using @RequestParam")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> getUserInfoUsingRequestParamResponseEntity(
			@ApiParam(value = "Valid userId. <br/>Example:101") @RequestParam(required = false) final Integer userId,
			@ApiParam(value = "Valid user name. <br/>Example:Ganesh") @RequestParam(required = true) final String userName,
			@ApiParam(value = "Valid user DOB. <br/>Example:2nd June 1992") @RequestParam(required = false) final LocalDate dob) {
		return new ResponseEntity<>(new UserDetails(userId, userName, dob, null), HttpStatus.OK);
	}

	@PostMapping(path = "/user/info/requestbody")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Get user details using @RequestBody")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public ResponseEntity<UserDetails> getUserInfoUsingRequestBody(
			@ApiParam(value = "User Details") @RequestBody(required = true) final UserDetails userDetails) {
		return new ResponseEntity<>(
				new UserDetails(userDetails.getUserId(), userDetails.getName(), userDetails.getDateOfBirth(), null),
				HttpStatus.OK);
	}

	@GetMapping(path = "/hello-world-internationalized")
	@ApiOperation(value = "hello-world-internationalized")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful request."),
			@ApiResponse(code = 400, message = "Malformed parameters or no results found."),
			@ApiResponse(code = 500, message = "Internal server error, more details in logs.") })
	public String helloWorldInternationalized() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
