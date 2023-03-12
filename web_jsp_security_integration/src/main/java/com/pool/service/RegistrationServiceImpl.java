package com.pool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.RegistrationDao;
import com.pool.formmodel.RegistrationForm;
import com.pool.model.CachePerson;
import com.pool.model.Registration;

import ma.glasnost.orika.MapperFacade;

@Service

public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	@Autowired
	private RegistrationDao registrationDao;

	@Transactional
	public Integer saveUser(RegistrationForm registrationForm) {
		Registration registration=formDomineMapperfaced.map(registrationForm, Registration.class);
		return registrationDao.saveUser(registration);
	}

	@Transactional
	public List<RegistrationForm> usersList() {
		List<Registration> registrations=null;
		registrations=registrationDao.usersList();
		List<RegistrationForm> registrationForms=new ArrayList<RegistrationForm>();
		for(Registration registration:registrations) {
			RegistrationForm registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
			registrationForms.add(registrationForm);
		}
		return registrationForms;
	}

	@Transactional
	public RegistrationForm updateUser(RegistrationForm registrationForm) {
		Registration registration=registrationDao.getUserByUserId(registrationForm.getUserId());
		formDomineMapperfaced.map(registrationForm, registration);
		//registrationDao.updateUser(registration);
		return registrationForm;
	}

	@Transactional
	public Integer deleteUser(Integer userid) {
		
		return registrationDao.deleteUser(userid);
	}

	@Transactional
	public RegistrationForm getUserByEmailAndPassword(String username, String password) {
		RegistrationForm registrationForm=null;
		Registration registration=registrationDao.getUserByEmailAndPassword(username, password);
		registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		return registrationForm;
	}
	@Transactional
	public RegistrationForm getUserByUserId(Integer userId) {
		RegistrationForm registrationForm=null;
		Registration registration=registrationDao.getUserByUserId(userId);
		registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		return registrationForm;
	}
	@Transactional
	public List<CachePerson> getAllCachePersons() {
		return registrationDao.getAllCachePersons();
	}

}
