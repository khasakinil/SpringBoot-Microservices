package com.restful.webservice.versioning.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservice.versioning.bean.Name;
import com.restful.webservice.versioning.bean.PersonV1;
import com.restful.webservice.versioning.bean.PersonV2;

import io.swagger.annotations.ApiOperation;

@RestController
public class VersioningPersonController {

	// URI Versioning
	@GetMapping("/v1/person")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "URI Versioning")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Raj Sawalagi");
	}

	// URI Versioning
	@GetMapping("/v2/person")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "URI Versioning")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Raj", "Sawalagi"));
	}

	// Request Parameter Versioning
	@GetMapping(path = "/person", params = "version=1")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Request Parameter Versioning")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Raj Sawalagi");
	}

	// Request Parameter Versioning
	@GetMapping(path = "/person", params = "version=2")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Request Parameter Versioning")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Raj", "Sawalagi"));
	}

	// Header Versioning
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Header Versioning")
	public PersonV1 getFirstVersionOfPersonHeader() {
		return new PersonV1("Raj Sawalagi");
	}

	// Header Versioning
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Header Versioning")
	public PersonV2 getSecondVersionOfPersonHEader() {
		return new PersonV2(new Name("Raj", "Sawalagi"));
	}

	// Media Type Versioning
	@GetMapping(path = "/person/accept", produces = "application/nk.company.app-v1+json")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Media Type Versioning")
	public PersonV1 getFirstVersionOfPersonMediaType() {
		return new PersonV1("Raj Sawalagi");
	}

	@GetMapping(path = "/person/accept", produces = "application/nk.company.app-v2+json")
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Media Type Versioning")
	public PersonV2 getSecondVersionOfPersonMediaType() {
		return new PersonV2(new Name("Raj", "Sawalagi"));
	}
}
