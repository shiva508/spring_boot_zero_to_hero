package com.pool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.UserRepository;
import com.pool.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional(readOnly = true)
	public User findUserByUserName(String email) {
		return userRepository.findUserByUserName(email);
	}

}
