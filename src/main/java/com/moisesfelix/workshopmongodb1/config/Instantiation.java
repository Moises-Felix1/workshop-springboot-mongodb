package com.moisesfelix.workshopmongodb1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moisesfelix.workshopmongodb1.domain.User;
import com.moisesfelix.workshopmongodb1.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Value("${user}")
	private String ambiente;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ambiente.contains("test"));
		System.out.println(ambiente);
		if(ambiente.contains("test")) {
			userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		}
	}

}
