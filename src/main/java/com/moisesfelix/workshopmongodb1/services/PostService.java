package com.moisesfelix.workshopmongodb1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesfelix.workshopmongodb1.domain.Post;
import com.moisesfelix.workshopmongodb1.repositories.PostRepository;
import com.moisesfelix.workshopmongodb1.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado"));
	}
}
