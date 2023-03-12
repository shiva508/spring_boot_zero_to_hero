package com.pool.service;

import java.util.List;
import com.pool.formmodel.RegistrationForm;
import com.pool.model.CachePerson;
import com.pool.model.Registration;

public interface RegistrationService {
	public Integer saveUser(RegistrationForm registrationForm);
	public List<RegistrationForm> usersList();
	public RegistrationForm updateUser(RegistrationForm registrationForm);
	public Integer deleteUser(Integer userid);
	public RegistrationForm getUserByEmailAndPassword(String username, String password);
	public RegistrationForm getUserByUserId(Integer userId);
	public List<CachePerson> getAllCachePersons();
}
