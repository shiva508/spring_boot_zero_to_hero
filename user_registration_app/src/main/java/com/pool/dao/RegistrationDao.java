package com.pool.dao;

import java.util.List;

import com.pool.model.Registration;



public interface RegistrationDao {
public Integer saveUser(Registration registration);
public List<Registration> usersList();
public void updateUser(Registration registration);
public Integer deleteUser(Integer userid);
public Registration getUserByEmailAndPassword(String username,String password);
public Registration getUserByUserId(Integer userId);
public Long isUserExist(String username);
}
