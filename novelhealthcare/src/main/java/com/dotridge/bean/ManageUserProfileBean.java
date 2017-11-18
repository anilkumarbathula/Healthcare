package com.dotridge.bean;

import java.io.Serializable;

public class ManageUserProfileBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String email;
	private long phoneNumber;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "ManageUserProfileBean [firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
}
