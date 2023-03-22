package com.restful.webservice.bean;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
	
	@JsonProperty("userID")
	private Integer userId;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;

	@Past(message = "Birth Date should be in past")
	private LocalDate dateOfBirth;

	public UserDetails(Integer userId, String name, LocalDate dateOfBirth) {
		super();
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
