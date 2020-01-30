package com.kryptow.springbootrest.repository;

import java.util.List;

import com.kryptow.springbootrest.model.PrivatePosts;

public interface PostDAO {
	
	public List<PrivatePosts> findAll();
	
	public PrivatePosts findById(int id);
	
	public List<PrivatePosts> findByFromID(String fromID);
}
