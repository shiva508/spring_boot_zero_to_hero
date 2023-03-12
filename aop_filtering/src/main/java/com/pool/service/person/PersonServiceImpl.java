package com.pool.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.model.person.Person;
import com.pool.repository.person.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Transactional
	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Transactional
	@Override
	public List<Person> getPersonList() {
		return personRepository.findAll();
	}

}
