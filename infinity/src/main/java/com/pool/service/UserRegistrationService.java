package com.infinity.service;

import com.infinity.model.UserRegistration;

public interface UserRegistrationService {
public UserRegistration saveUserRegistration(UserRegistration registration);

public UserRegistration registeredUser(String email,String password);
}
