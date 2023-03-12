package com.pool.service;

import java.util.List;
import java.util.Optional;

import com.pool.model.User;

public interface UserService {
public User saveUser(User user);
public List<User> users();
public Optional<User> findUser(Integer userId);
public void deleteUser(Integer userId);
}
