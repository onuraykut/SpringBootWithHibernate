package com.kryptow.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.repository.UserDAO;
import com.kryptow.springbootrest.service.FileStorageService;
import com.kryptow.springbootrest.service.FileStorageServiceProfile;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserDAO userDAO;
	 @Autowired
	 private FileStorageService fileStorageService;
	@Autowired
	public UserController(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	@GetMapping("/all")
	public List<User> findAll() {
		return userDAO.findAll();
	}
	@GetMapping("/getEkip")
	public List<User> getEkip() {
		return userDAO.getEkip();
	}
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	@PostMapping("/get")
	public User findById(@PathVariable int userId) {
		return userDAO.findById(userId);
	}
	@PostMapping("/save")
	public void insert(@RequestParam String uid,@RequestParam String mail_address) {
		User user = new User(uid,mail_address);
		this.userDAO.save(user);
	}
	@PostMapping("/addUsername")
	public void add_username(@RequestParam String uid,@RequestParam String username,@RequestParam String name) {
		User user = userDAO.findByUid(uid);
		user.setUsername(username);
		user.setName(name);
		this.userDAO.save(user);
		System.out.println(username+"--"+name);
	}
	@PostMapping("/addUsernameP")
	public void add_usernameP(@RequestParam("file") MultipartFile file,@RequestParam("ext") String ext,@RequestParam String uid,@RequestParam String username,@RequestParam String name) {
		User user = userDAO.findByUid(uid);
		user.setUsername(username);
		user.setName(name); 
	//	new Thread(() -> {
			try {
				Boolean sss = fileStorageService.storeFileProfile(file, ext, uid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}).start();
		
		this.userDAO.save(user);
	}
	
}
