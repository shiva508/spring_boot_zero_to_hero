package com.pool.model.contact;

import java.net.URL;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pool.model.phone.Phone;

@Entity
@Table
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Name name;

    private String notes;

    private String website;

    private boolean starred;
    
    @OneToOne(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Phone phone;

	public Contact() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public void processChild(Phone newPhoneNumber) {
		newPhoneNumber.setContact(this);
		this.setPhone(newPhoneNumber);
	}
	
}
