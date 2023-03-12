/**
 * 
 */
package com.pool.rest.service.dressaddress;

import java.util.List;

import com.pool.rest.form.DressDetailsForm;

/**
 * @author dasar
 *
 */
public interface DressAddressService {
public DressDetailsForm saveDressDetails(DressDetailsForm dressDetailsFormIP);
public List<DressDetailsForm> getDressDetailsList();
public DressDetailsForm updateDressDetails(DressDetailsForm dressDetailsFormIP);
public void deleteDressDetails(String dressAddressCode);
public DressDetailsForm getDressDetailsFormByDressAddressCode(String dressAddressCode);
}
