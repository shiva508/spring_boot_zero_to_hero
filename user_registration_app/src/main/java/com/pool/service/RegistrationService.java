package com.pool.service;


import java.util.List;

import com.pool.formmodel.RegistrationForm;


public interface RegistrationService {
	public Integer saveUser(RegistrationForm registrationForm);
	public List<RegistrationForm> usersList();
	public void updateUser(RegistrationForm registrationForm);
	public Integer deleteUser(Integer userid);
	public RegistrationForm getUserByEmailAndPassword(String username,String password);
	public Long isUserExist(String username);
	public RegistrationForm getUserByUserId(Integer userId);
}
