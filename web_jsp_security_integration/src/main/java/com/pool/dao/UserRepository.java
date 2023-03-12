package com.pool.dao;

import com.pool.model.User;

public interface UserRepository {
public User findUserByUserName(String email);
}
