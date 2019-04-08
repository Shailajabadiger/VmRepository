package com.mindtree.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.dao.UserDao;
import com.mindtree.repository.UserRepository;
@Service
public class DetailsService implements UserDetailsService{

	@Autowired
    UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getOne(username);
		return new CustomUserDetails(user);
	}

}
