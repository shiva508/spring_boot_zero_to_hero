package com.pool.service.contact;

import java.util.List;

import com.pool.model.contact.Contact;

public interface ContactService {
	public Contact saveContact(Contact contact);
	public List<Contact> getAllConacts();
}
