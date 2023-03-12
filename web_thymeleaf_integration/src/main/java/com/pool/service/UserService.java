package com.pool.service;

import java.util.List;

import com.pool.domine.User;

public interface UserService {
	public User saveUser(User user);

	public List<User> getUsers();

	public User getUserByEmail(String email);

	public List<User> getUserByUserId(Integer userId);
}
