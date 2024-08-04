package com.moisesfelix.workshopmongodb1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesfelix.workshopmongodb1.domain.User;
import com.moisesfelix.workshopmongodb1.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

}
