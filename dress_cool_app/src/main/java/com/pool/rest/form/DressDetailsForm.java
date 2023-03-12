package com.pool.rest.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DressDetailsForm {
	private String dressAddressCode;
	private Integer dressType;
	@NotNull
	@Size( min = 4,max = 20)
	private String dressName;
	private Double dressPrice;
	private Date productCreatedOn;
	
	public DressDetailsForm() {
		
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
		this.productCreatedOn = new Date();
	}
	
	@Override
	public String toString() {
		return "DressDetailsForm [dressAddressCode=" + dressAddressCode + ", dressType=" + dressType + ", dressName="
				+ dressName + ", dressPrice=" + dressPrice + ", productCreatedOn=" + productCreatedOn + "]";
	}
	
}
