package com.restful.webservice.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserPosts {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 10)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserDetails user;

	public UserPosts() {
		super();
	}

	public UserPosts(Integer id, String description, UserDetails user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPosts [id=" + id + ", description=" + description + ", user=" + user + "]";
	}

}
