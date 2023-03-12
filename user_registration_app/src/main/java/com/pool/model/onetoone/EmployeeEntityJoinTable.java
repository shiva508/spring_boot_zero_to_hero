package com.pool.model.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee_JOIN", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")/*,
		@UniqueConstraint(columnNames = "EMAIL")*/ })
public class EmployeeEntityJoinTable implements Serializable {

	private static final long serialVersionUID = -1798070786993154676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer employeeId;

	@Column(
			name = "EMAIL", 
			unique = false, 
			nullable = false, 
			length = 100)
	private String email;

	@Column(
			name = "FIRST_NAME", 
			unique = false, 
			nullable = false, 
			length = 100)
	private String firstName;

	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
			name="EMPLOYEEJOIN_ACCCOUNT", 
			joinColumns = @JoinColumn(name="EMPLOYEE_ID"), 
			inverseJoinColumns = @JoinColumn(name="ACCOUNT_ID")
			)
	private AccountEntityJoinTable account;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public AccountEntityJoinTable getAccount() {
		return account;
	}

	public void setAccount(AccountEntityJoinTable account) {
		this.account = account;
	}

}
