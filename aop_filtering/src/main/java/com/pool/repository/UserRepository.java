package com.pool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
