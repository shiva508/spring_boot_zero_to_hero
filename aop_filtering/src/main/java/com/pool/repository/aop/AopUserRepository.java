package com.pool.repository.aop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pool.model.aop.AopUser;

@Repository
public interface AopUserRepository extends JpaRepository<AopUser, Integer> {

}
