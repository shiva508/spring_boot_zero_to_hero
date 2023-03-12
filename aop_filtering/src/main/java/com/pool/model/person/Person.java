package com.pool.model.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NaturalId;
import com.pool.model.phone.Phone;

@Entity
@Table
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NaturalId
	private String registrationNumber;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	private List<String> phones = new ArrayList<>();

	//@Temporal(TemporalType.TIMESTAMP)
    @ElementCollection
    @CollectionTable(name = "phone_register")
    @Column(name = "since")
    private Map<String, String> phoneRegister = new HashMap<>();

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Map<String, String> getPhoneRegister() {
		return phoneRegister;
	}

	public void setPhoneRegister(Map<String, String> phoneRegister) {
		this.phoneRegister = phoneRegister;
	}


}
