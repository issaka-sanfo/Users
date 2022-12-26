package com.isanf.users.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isanf.users.dao.entities.Contact;
import com.isanf.users.dao.repositories.ContactRepository;

@RestController
public class ContactRestController {
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/contacts")
	public List<Contact> listContacts(){
		return contactRepository.findAll();	
	}
	
	@PostMapping("/contacts")
	public Contact save(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
}
