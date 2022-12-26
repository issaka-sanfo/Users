package com.isanf.users;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.isanf.users.config.RsakeysConfig;
import com.isanf.users.dao.entities.Contact;
import com.isanf.users.dao.repositories.ContactRepository;

@SpringBootApplication
@EnableConfigurationProperties(RsakeysConfig.class)
public class UsersApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
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
