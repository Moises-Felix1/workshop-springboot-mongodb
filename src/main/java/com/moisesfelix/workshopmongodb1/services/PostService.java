package com.moisesfelix.workshopmongodb1.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesfelix.workshopmongodb1.domain.Post;
import com.moisesfelix.workshopmongodb1.repositories.PostRepository1;
import com.moisesfelix.workshopmongodb1.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository1 repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, Date min, Date max){
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullsearch(text, min, max);
	}
}
