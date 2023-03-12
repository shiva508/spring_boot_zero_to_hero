package com.pool.service.person;

import java.util.List;

import com.pool.model.person.Person;

public interface PersonService {
	public Person savePerson(Person person);

	public List<Person> getPersonList();
}
