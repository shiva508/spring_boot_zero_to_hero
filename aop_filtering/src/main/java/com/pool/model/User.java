package com.pool.model;



import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table
/*
 * @Data
 * 
 * @NoArgsConstructor
 * 
 * @Setter
 * 
 * @Getter
 * 
 * @ToString
 */
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	@NotBlank
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	public User() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", createdDate="
				+ createdDate + "]";
	}
	

	

}
