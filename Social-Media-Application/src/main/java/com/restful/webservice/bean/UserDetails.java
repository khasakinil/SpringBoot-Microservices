package com.restful.webservice.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UserDetails {

	@JsonProperty("userID")
	@Id
	@GeneratedValue
	private Integer userId;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;

	@Past(message = "Birth Date should be in past")
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<UserPosts> posts;

	public UserDetails() {
		super();
	}

	public UserDetails(Integer userId, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Past(message = "Birth Date should be in past") LocalDate dateOfBirth, List<UserPosts> posts) {
		super();
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.posts = posts;
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

	public List<UserPosts> getPosts() {
		return posts;
	}

	public void setPosts(List<UserPosts> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", posts=" + posts
				+ "]";
	}

}
