package com.moisesfelix.workshopmongodb1.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.moisesfelix.workshopmongodb1.domain.Post;

@Repository
public interface PostRepository1 extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
