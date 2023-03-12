package com.infinity.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRegistration {
	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private Integer userRegistrationId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserRegistration() {
		super();
	}

	public Integer getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Integer userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRegistration [userRegistrationId=" + userRegistrationId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + "]";
	}

}
