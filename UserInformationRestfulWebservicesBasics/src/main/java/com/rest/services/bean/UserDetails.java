package com.rest.services.bean;

public class UserDetails {

	private String firstName;
	private String lastName;
	private String city;
	private int pinCode;

	public UserDetails(String firstName, String lastName, String city, int pinCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.pinCode = pinCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", pinCode="
				+ pinCode + "]";
	}

}
