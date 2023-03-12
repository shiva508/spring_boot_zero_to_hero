package com.pool.model.phone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pool.model.contact.Contact;
import com.pool.util.model.PhoneType;

@Entity
@Table
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "phone_number")
	private String number;
	
	@Enumerated(EnumType.ORDINAL)
	private PhoneType phoneType;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	//@MapsId
	@JsonIgnore
	private Contact contact;

	public Phone() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
