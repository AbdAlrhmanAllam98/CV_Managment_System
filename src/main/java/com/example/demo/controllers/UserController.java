package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;	
	
	@RequestMapping(method = RequestMethod.POST,value =("/create/user"))
	public void createUser(@RequestBody User user) {
		userService.add(user);
	}
	@RequestMapping("/getAll/users")
	public List<User>  getAllUsers(){
		return userService.getAllUsers();	
	}
	
	@RequestMapping("/get/user/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping(method =RequestMethod.PUT,value="/update/user/{userId}")
	public void updateUser(@PathVariable Integer userId,@RequestBody User user) {
		userService.updateUser(userId,user);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/delete/user/{userId}")
	public void deleteUser (@PathVariable Integer userId) {
		userService.deleteUser(userId);
	}
}
