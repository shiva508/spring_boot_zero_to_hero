package com.pool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pool.domine.User;

@Service
public class UserServiceImpl implements UserService {
	private static List<User> users;
	static {
		users = new ArrayList<>();
	}

	@Override
	public User saveUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		Predicate<User> predicateUser = user -> user.getEmail().equals(email);
		return users.stream().filter(predicateUser).findFirst().orElse(null);
	}

	@Override
	public List<User> getUserByUserId(Integer userId) {
		List<User> afterDeleted = users.stream().filter(user -> !user.getUserId().equals(userId))
				.collect(Collectors.toList());
		users = afterDeleted;
		return users;
	}
}
