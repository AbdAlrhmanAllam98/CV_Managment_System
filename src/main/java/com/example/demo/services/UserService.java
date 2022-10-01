package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
		
	public void add(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> users=new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	public void updateUser(Integer userId,User user) {
		User oldUser=this.getUser(userId);
		user.setId(oldUser.getId());
		user.setEmail(oldUser.getEmail());
		userRepository.save(user);
		
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
