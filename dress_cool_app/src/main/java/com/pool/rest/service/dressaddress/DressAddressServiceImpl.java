/**
 * 
 */
package com.pool.rest.service.dressaddress;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pool.exception.model.DressNotFoundException;
import com.pool.rest.form.DressDetailsForm;
import com.pool.rest.model.DressDetailsModel;
import com.pool.rest.repository.dressaddress.DressAddressRepository;

import ma.glasnost.orika.MapperFacade;

/**
 * @author dasar
 *
 */
@Service
public class DressAddressServiceImpl implements DressAddressService {
	@Autowired
	private DressAddressRepository dressAddressRepository;

	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public DressDetailsForm saveDressDetails(DressDetailsForm dressDetailsFormIP) {
		DressDetailsModel dressDetailsModelIP = formDomineMapperfaced.map(dressDetailsFormIP, DressDetailsModel.class);
		DressDetailsModel dressDetailsModelOP = dressAddressRepository.save(dressDetailsModelIP);
		DressDetailsForm dressDetailsFormOP = formDomineMapperfaced.map(dressDetailsModelOP, DressDetailsForm.class);
		return dressDetailsFormOP;
	}

	@Override
	@Transactional
	public List<DressDetailsForm> getDressDetailsList() {
		List<DressDetailsForm> dressDetailsFormListOP = new ArrayList<>();
		List<DressDetailsModel> dressDetailsListIP = dressAddressRepository.findAll();
		processdressDetailsList(dressDetailsFormListOP, dressDetailsListIP);
		return dressDetailsFormListOP;
	}

	@Override
	@Transactional
	public DressDetailsForm updateDressDetails(DressDetailsForm dressDetailsFormIP) {
		Optional<DressDetailsModel> dressDetailsOP=dressAddressRepository.findById(dressDetailsFormIP.getDressAddressCode());
		formDomineMapperfaced.map(dressDetailsFormIP, dressDetailsOP.get());
		return dressDetailsFormIP;
	}

	@Override
	@Transactional
	public void deleteDressDetails(String dressAddressCode) {
		dressAddressRepository.deleteById(dressAddressCode);
	}

	@Override
	@Transactional
	public DressDetailsForm getDressDetailsFormByDressAddressCode(String dressAddressCode) {
		DressDetailsModel dressDetailsModelOP = dressAddressRepository.getOne(dressAddressCode);
		DressDetailsForm dressDetailsFormOP=null;
		
		  if(dressDetailsModelOP !=null) { 
			  dressDetailsFormOP =
		  formDomineMapperfaced.map(dressDetailsModelOP, DressDetailsForm.class); 
		  }
		 
		return dressDetailsFormOP;
	}

	public void processdressDetailsList(List<DressDetailsForm> dressDetailsFormListOP,
			List<DressDetailsModel> dressDetailsListIP) {
		dressDetailsFormListOP.addAll(dressDetailsListIP.stream()
				.map(dressDetails -> formDomineMapperfaced.map(dressDetails, DressDetailsForm.class))
				.collect(Collectors.toList()));

	}
}
