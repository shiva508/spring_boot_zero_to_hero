/**
 * 
 */
package com.pool.rest.service.dressaddress;

import java.util.List;

import com.pool.rest.form.DressTypeForm;

/**
 * @author dasar
 *
 */
public interface DressTypeService {
	public DressTypeForm saveDressType(DressTypeForm dressTypeForm);
	public DressTypeForm updateDressType(DressTypeForm dressTypeForm);
	public List<DressTypeForm> dressTypeForms();
	public void deleteDressTypeForm(Integer dressTypeId);
}
