package com.infinity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.model.UserRegistration;
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
