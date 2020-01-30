package com.kryptow.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kryptow.springbootrest.model.PrivatePosts;
import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.repository.PostDAO;
import com.kryptow.springbootrest.repository.UserDAO;


@RestController
@RequestMapping("/api/posts")
public class PrivatePostsController {
private PostDAO postDAO;
	
	@Autowired
	public PrivatePostsController(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	@GetMapping("/all")
	public List<PrivatePosts> getAll()  {
		List<PrivatePosts> posts = this.postDAO.findAll();
		
		return posts;
	}
	@PutMapping
	public void insert(@RequestBody PrivatePosts privatePosts) {
		//this.postDAO.insert(privatePosts);
	}
	
	@GetMapping("/fromID/{fromID}")
    public List<PrivatePosts> getByFromID(@PathVariable("fromID") String fromID){
        List<PrivatePosts> posts = this.postDAO.findByFromID(fromID);
        return posts;
    }
	
}
