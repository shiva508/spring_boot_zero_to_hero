package com.infinity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infinity.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

}
