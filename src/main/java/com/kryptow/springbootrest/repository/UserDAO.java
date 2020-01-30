package com.kryptow.springbootrest.repository;

import java.util.List;

import com.kryptow.springbootrest.model.User;

public interface UserDAO {
	public List<User> findAll();
	
	public User findById(int theID);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
}
