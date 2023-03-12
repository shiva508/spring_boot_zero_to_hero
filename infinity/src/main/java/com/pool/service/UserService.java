package com.infinity.service;

import com.infinity.form.UserForm;

public interface UserService {
public UserForm saveUser(UserForm userForm); 
public UserForm getUser(Integer userId);

}
