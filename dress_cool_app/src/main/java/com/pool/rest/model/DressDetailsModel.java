package com.pool.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DRESS_DETAILS")
public class DressDetailsModel {
	@Id
	@Column(name = "DRESS_ADDRESS_CODE", unique = true, columnDefinition = "VARCHAR(100)")
	private String dressAddressCode;
	@Column(name = "DRESS_TYPE")
	private Integer dressType;
	private String dressName;
	private Double dressPrice;
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date productCreatedOn;

	public DressDetailsModel() {
	}

	public String getDressAddressCode() {
		return dressAddressCode;
	}

	public void setDressAddressCode(String dressAddressCode) {
		this.dressAddressCode = dressAddressCode;
	}

	public Integer getDressType() {
		return dressType;
	}

	public void setDressType(Integer dressType) {
		this.dressType = dressType;
	}

	public String getDressName() {
		return dressName;
	}

	public void setDressName(String dressName) {
		this.dressName = dressName;
	}

	public Double getDressPrice() {
		return dressPrice;
	}

	public void setDressPrice(Double dressPrice) {
		this.dressPrice = dressPrice;
	}

	public Date getProductCreatedOn() {
		return productCreatedOn;
	}

	public void setProductCreatedOn(Date productCreatedOn) {
		this.productCreatedOn = productCreatedOn;
	}

	@Override
	public String toString() {
		return "DressDetailsModel [dressAddressCode=" + dressAddressCode + ", dressType=" + dressType + ", dressName="
				+ dressName + ", dressPrice=" + dressPrice + "]";
	}

}
