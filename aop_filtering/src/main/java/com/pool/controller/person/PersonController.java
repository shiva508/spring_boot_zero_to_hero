package com.pool.controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.person.Person;
import com.pool.service.person.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping("/allpersons")
	public List<Person> getPersonList() {
		return personService.getPersonList();
	}

}
