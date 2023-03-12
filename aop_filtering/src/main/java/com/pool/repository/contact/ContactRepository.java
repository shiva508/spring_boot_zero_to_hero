package com.pool.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pool.model.contact.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
