/**
 * 
 */
package com.pool.rest.service.dressaddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.rest.form.DressTypeForm;
import com.pool.rest.repository.dressaddress.DressTypeRepository;

import ma.glasnost.orika.MapperFacade;

/**
 * @author dasar
 *
 */
@Service
public class DressTypeServiceImpl implements DressTypeService {
	@Autowired
	private DressTypeRepository dressTypeRepository;
	
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	
	@Override
	@Transactional
	public void deleteDressTypeForm(Integer dressTypeId) {
		dressTypeRepository.deleteById(dressTypeId);
	}

	@Override
	@Transactional
	public DressTypeForm saveDressType(DressTypeForm dressTypeForm) {
		return null;
	}

	@Override
	@Transactional
	public List<DressTypeForm> dressTypeForms() {
		return null;
	}

	@Override
	@Transactional
	public DressTypeForm updateDressType(DressTypeForm dressTypeForm) {
		// TODO Auto-generated method stub
		return null;
	}
}
