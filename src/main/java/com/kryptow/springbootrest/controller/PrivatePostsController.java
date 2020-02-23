package com.kryptow.springbootrest.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.posts.PrivatePosts;
import com.kryptow.springbootrest.repository.PostDAO;
import com.kryptow.springbootrest.repository.UserDAO;
import com.kryptow.springbootrest.service.FileStorageService;


@RestController
@RequestMapping("/post")
public class PrivatePostsController {
private PostDAO postDAO;
private UserDAO userDAO;
	@Autowired
	public PrivatePostsController(PostDAO postDAO,UserDAO theUserDAO) {
		this.postDAO = postDAO;
		this.userDAO = theUserDAO;
	}
	 @Autowired
	    private FileStorageService fileStorageService;
	    
	    @PostMapping("/uploadFile")
	    public void uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("ext") String ext,@RequestParam String fromID,
	    		@RequestParam String toID,@RequestParam String message,@RequestParam String comment,@RequestParam int rating) {
	        String fileName = fileStorageService.storeFile(file,ext);
	        PrivatePosts privates = new PrivatePosts(fromID, toID, message, fileName, comment, rating);
	        System.out.println(fileName);
	        System.out.println(privates);
	    	this.postDAO.save(privates);	
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
	@PostMapping("/toID")
    public List<PrivatePosts> findByToID(@RequestParam("toID") String toID){
		 User user = userDAO.findByUid(toID);
        List<PrivatePosts> posts = this.postDAO.findByToID(toID);
        for(int i=0;i<posts.size();i++) {
        	
        }
       
       
        return posts;
    }
	
	public ResponseEntity<PrivatePosts> returnStatus(PrivatePosts privatePosts) {
		return new ResponseEntity<PrivatePosts> (privatePosts,HttpStatus.OK);
	}
	
}
