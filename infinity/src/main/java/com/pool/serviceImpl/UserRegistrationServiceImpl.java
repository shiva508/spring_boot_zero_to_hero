package com.infinity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinity.dao.UserRegistrationRepository;
import com.infinity.model.UserRegistration;
import com.infinity.service.UserRegistrationService;
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	UserRegistrationRepository userRegistrationRepository; 
	@Override
	@Transactional
	public UserRegistration saveUserRegistration(UserRegistration registration) {
		UserRegistration savedUser=null;
		UserRegistration userRegistration=userRegistrationRepository.save(registration);
		savedUser=userRegistration;
		return savedUser;
	}

	@Override
	@Transactional
	public UserRegistration registeredUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
