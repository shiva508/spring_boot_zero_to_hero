package com.pool.service;

import com.pool.model.User;

public interface UserService {
	public User findUserByUserName(String email);
}
