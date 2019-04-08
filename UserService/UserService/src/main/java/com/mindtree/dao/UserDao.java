package com.mindtree.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.entity.User;
import com.mindtree.repository.UserRepository;

@Service
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();	
		}

	public User save(@Valid @RequestBody User user) {
		
		return userRepository.save(user);
	}
	public List<User >getUsers()
	{
		return userRepository.findAll();
		
	}

	public User findOne(@RequestParam String u_name) {
		
		return userRepository.getOne(u_name);
	}

	public void delete(User user1) {
		userRepository.delete(user1);
		
	}

	
}
