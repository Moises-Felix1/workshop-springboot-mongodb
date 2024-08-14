package com.moisesfelix.workshopmongodb1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesfelix.workshopmongodb1.domain.User;
import com.moisesfelix.workshopmongodb1.dto.UserDTO;
import com.moisesfelix.workshopmongodb1.repositories.UserRepository;
import com.moisesfelix.workshopmongodb1.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) { 
		 Optional<User> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void deleteBy(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User FromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
