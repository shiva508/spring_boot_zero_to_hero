package com.pool.model.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class PersonDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nickName;

	@OneToOne
	//@MapsId
	@PrimaryKeyJoinColumn
	private Person person;

	public PersonDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
