package com.kryptow.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.posts.PrivatePosts;
import com.kryptow.springbootrest.repository.PostDAO;
import com.kryptow.springbootrest.repository.UserDAO;


@RestController
@RequestMapping("/api/post")
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
	public void save(@RequestBody PrivatePosts privatePosts) {
		this.postDAO.save(privatePosts);	
	}
//	@PutMapping("/posts")
//	public ResponseEntity<PrivatePosts> save(@RequestBody PrivatePosts privatePosts) {
//		this.postDAO.save(privatePosts);
//		return new ResponseEntity<PrivatePosts> (privatePosts,HttpStatus.OK);
//		
//	}
	
	@GetMapping("/{postID}")
	public PrivatePosts findById(@PathVariable("postID") int postID) {
		return postDAO.findById(postID);
	}
	@GetMapping("/fromID/{fromID}")
    public List<PrivatePosts> findByFromID(@PathVariable("fromID") String fromID){
        List<PrivatePosts> posts = this.postDAO.findByFromID(fromID);
        return posts;
    }
	@GetMapping("/toID/{toID}")
    public List<PrivatePosts> findByToID(@PathVariable("toID") String toID){
        List<PrivatePosts> posts = this.postDAO.findByToID(toID);
        return posts;
    }
	
	public ResponseEntity<PrivatePosts> returnStatus(PrivatePosts privatePosts) {
		return new ResponseEntity<PrivatePosts> (privatePosts,HttpStatus.OK);
	}
	
}
