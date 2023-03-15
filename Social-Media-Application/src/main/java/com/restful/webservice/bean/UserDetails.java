package com.restful.webservice.bean;

import java.time.LocalDate;

public class UserDetails {
	private Integer userId;
	private String name;
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
