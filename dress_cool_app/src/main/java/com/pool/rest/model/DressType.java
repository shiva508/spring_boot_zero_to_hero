package com.pool.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRESS_TYPE")
public class DressType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer dressTypeId;
	private String derssTypeName;
	public DressType() {
	}
	public Integer getDressTypeId() {
		return dressTypeId;
	}
	public void setDressTypeId(Integer dressTypeId) {
		this.dressTypeId = dressTypeId;
	}
	public String getDerssTypeName() {
		return derssTypeName;
	}
	public void setDerssTypeName(String derssTypeName) {
		this.derssTypeName = derssTypeName;
	}
	@Override
	public String toString() {
		return "DressType [dressTypeId=" + dressTypeId + ", derssTypeName=" + derssTypeName + "]";
	}
	
}
