package com.kryptow.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.repository.UserDAO;

@RestController
@RequestMapping
public class UserController {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserController(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userDAO.findAll();
	}
	@GetMapping("/users/{userId}")
	public User findById(@PathVariable int userId) {
		return userDAO.findById(userId);
	}
	@PutMapping("/users")
	public void insert(@RequestBody User user) {
		this.userDAO.save(user);
	}
}
