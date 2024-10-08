package com.moisesfelix.workshopmongodb1.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moisesfelix.workshopmongodb1.domain.Post;
import com.moisesfelix.workshopmongodb1.domain.User;
import com.moisesfelix.workshopmongodb1.dto.AuthorDTO;
import com.moisesfelix.workshopmongodb1.dto.CommentDTO;
import com.moisesfelix.workshopmongodb1.repositories.PostRepository1;
import com.moisesfelix.workshopmongodb1.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Value("${user}")
	private String ambiente;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository1 postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		System.out.println(ambiente.contains("test"));
		System.out.println(ambiente);
		if (ambiente.contains("test")) {
			
			userRepository.deleteAll();
			postRepository.deleteAll();
			
			User maria = new User(null, "Maria Brown", "maria@gmail.com");
			User alex = new User(null, "Alex Green", "alex@gmail.com");
			User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
			userRepository.saveAll(Arrays.asList(maria, alex, bob));
			
			Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem ", "Partiu viajar para São Paulo. Abraços!", new AuthorDTO(maria));
			Post post2 = new Post(null, sdf.parse("21/03/2024"), "Bom dia!", "Acordei entusiasmado hoje! ", new AuthorDTO(maria));
			
			CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2024"), new AuthorDTO(alex));
			CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2024"), new AuthorDTO(bob));
			CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2024"), new AuthorDTO(alex));
			
			post1.getComments().addAll(Arrays.asList(c1, c2));
			post2.getComments().addAll(Arrays.asList(c3));

			postRepository.saveAll(Arrays.asList(post1, post2));
			
			maria.getPosts().addAll(Arrays.asList(post1, post2));
			userRepository.save(maria);
		}
	}

}
