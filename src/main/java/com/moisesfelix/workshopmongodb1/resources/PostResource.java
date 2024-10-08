package com.moisesfelix.workshopmongodb1.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moisesfelix.workshopmongodb1.domain.Post;
import com.moisesfelix.workshopmongodb1.resources.util.URL;
import com.moisesfelix.workshopmongodb1.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@GetMapping(value="/titlesearch")
 	public ResponseEntity<List<Post>> Title(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/fullsearch")
 	public ResponseEntity<List<Post>> fullsearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="min", defaultValue="") String min,
 			@RequestParam(value="max", defaultValue="") String max) {
		text = URL.decodeParam(text);
		Date minDate = URL.covertDate(min, new Date(0L));
		Date maxDate = URL.covertDate(max, new Date());
		List<Post> list = service.fullsearch(text, minDate, maxDate);
		return ResponseEntity.ok().body(list);
	}
}
