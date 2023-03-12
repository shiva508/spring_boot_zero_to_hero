package com.pool.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
