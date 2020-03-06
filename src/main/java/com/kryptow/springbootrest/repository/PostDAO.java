package com.kryptow.springbootrest.repository;

import java.util.List;

import com.kryptow.springbootrest.model.posts.DegerlendirmeDetaylari;
import com.kryptow.springbootrest.model.posts.PrivatePosts;

public interface PostDAO {
	
	public List<PrivatePosts> findAll();
	
	public PrivatePosts findById(int id);
	
	public List<PrivatePosts> findByFromID(String fromID);

	public List<PrivatePosts> findByToID(String toID);

	public void save(PrivatePosts privatePosts);

	public void delete(int id);
	
	public DegerlendirmeDetaylari getDegerlendirmeDetaylari(int postID);
}
