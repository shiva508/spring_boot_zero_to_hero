package com.pool.controller.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.contact.Contact;
import com.pool.service.contact.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveContact(@RequestBody Contact contact) {
		Contact savedContact=contactService.saveContact(contact);
		return new ResponseEntity<>(savedContact, HttpStatus.OK);
	}

	@GetMapping("/allcontacts")
	public ResponseEntity<?> getAllConacts() {
		List<Contact> contacts=contactService.getAllConacts();
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
}
