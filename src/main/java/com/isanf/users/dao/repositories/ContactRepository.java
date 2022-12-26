package com.isanf.users.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isanf.users.dao.entities.Contact;
 
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
