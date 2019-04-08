package com.mindtree.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dao.UserDao;
import com.mindtree.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@SuppressWarnings("unused")
	private final Logger LOG = Logger.getLogger(UserController.class);
	
	@Autowired
    UserDao userDao;
	
	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user)
	{
		return userDao.save(user);
	}
	@GetMapping("/getAll")
	public Iterable<User> getAllUsers()
	{
		return userDao.getAllUsers();
		/*LOG.info("Get all Method");
		String principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

		LOG.info("NAme is "+principle);
		return userDao.findOne(principle);*/
		
	}
	@GetMapping("/User/{u_name}")
	public ResponseEntity<User>getUserById(@PathVariable (value="u_name") String u_name) 
	{
		User user1=userDao.findOne(u_name);
		if(user1==null)
		{
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.ok().body(user1);
	}
	@PutMapping("/User/{u_name}")
	public ResponseEntity<User>updateUser(@PathVariable (value="u_name") String u_name, @Valid @RequestBody User  userDetails)
	{
		User user1=userDao.findOne(u_name);
		if(user1!=null)
		{
			user1.setName(userDetails.getName());
			user1.setEmial(userDetails.getEmial());
			user1.setPassword(userDetails.getPassword());
			User updateUser=userDao.save(user1);
		return ResponseEntity.ok().body(updateUser);
		
	}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("user/{u_name}")
	public ResponseEntity<User>deleteUser(@PathVariable (value="u_name") String u_name)
	{
		User user1=userDao.findOne(u_name);
		if(user1!=null)
		{
			userDao.delete(user1);
			return ResponseEntity.ok().body(user1);
		}
		return ResponseEntity.notFound().build();	
	}
	
	
}
