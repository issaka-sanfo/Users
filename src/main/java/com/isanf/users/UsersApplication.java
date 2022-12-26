package com.isanf.users;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isanf.users.dao.entities.Contact;
import com.isanf.users.dao.repositories.ContactRepository;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of("C1","C2","C3").forEach(t->{
			contactRepository.save(new Contact(null, t, null, null, null, null, null));
		});
		
		contactRepository.findAll().forEach(t->{
			System.out.println(t.getFirstName());
		});
	}

}
