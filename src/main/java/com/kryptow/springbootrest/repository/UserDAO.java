package com.kryptow.springbootrest.repository;

import java.util.List;

import com.kryptow.springbootrest.model.User;

public interface UserDAO {
	public List<User> findAll();
	
	public List<User> getEkip();
	
	public List<User> getUsers();
	
	public User findById(int theID);
	
	public void save(User theUser);
	
	public void deleteById(int theId);

	public User findByUid(String uid);
	
	public String findUsernameByPostId(int id);
}
