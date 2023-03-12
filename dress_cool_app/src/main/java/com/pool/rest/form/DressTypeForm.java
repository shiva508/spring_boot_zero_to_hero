/**
 * 
 */
package com.pool.rest.form;

import javax.validation.constraints.NotEmpty;

/**
 * @author dasar
 *
 */
public class DressTypeForm {
	private Integer dressTypeId;
	@NotEmpty
	private String derssTypeName;
	public DressTypeForm() {
		
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
		return "DressTypeForm [dressTypeId=" + dressTypeId + ", derssTypeName=" + derssTypeName + "]";
	}
	
}
