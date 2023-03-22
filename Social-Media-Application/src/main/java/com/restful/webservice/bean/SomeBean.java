package com.restful.webservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "lastName" })
public class SomeBean {

	// for static filtering we can use @JsonIgnore on field level and
	// @JsonIgnoreProperties on class level to ignore list of fields
	// This feature is used to ignore the field and its value in response

	private String firstName;
	private String lastName;

	@JsonIgnore
	private String mobileNumber;

	public SomeBean() {
		super();
	}

	public SomeBean(String firstName, String lastName, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "SomeBean [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

}
