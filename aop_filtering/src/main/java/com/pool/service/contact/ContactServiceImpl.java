package com.pool.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.model.contact.Contact;
import com.pool.repository.contact.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Transactional
	@Override
	public Contact saveContact(Contact contact) {
		contact.processChild(contact.getPhone());
		return contactRepository.save(contact);
	}

	@Transactional
	@Override
	public List<Contact> getAllConacts() {
		return contactRepository.findAll();
	}

}
