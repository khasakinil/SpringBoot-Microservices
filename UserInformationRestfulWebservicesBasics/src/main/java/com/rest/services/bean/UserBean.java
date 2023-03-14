package com.rest.services.bean;

public class UserBean {

	private String message;
	private String user;

	public String getMessage() {
		return message;
	}

	public UserBean(String message, String user) {
		super();
		this.message = message;
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", user=" + user + "]";
	}

}
