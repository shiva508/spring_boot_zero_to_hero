package com.pool.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.model.User;
import com.pool.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Override
	@Transactional
	public List<User> users() {
		return userRepository.findAll();
	}
	@Override
	@Transactional
	public Optional<User> findUser(Integer userId) {
		return userRepository.findById(userId);
	}
	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
