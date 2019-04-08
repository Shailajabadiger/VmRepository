package com.mindtree.entity;

import java.util.Collection;

import org.jboss.logging.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Service
public class CustomUserDetails implements UserDetails{

	private final Logger LOG=Logger.getLogger(CustomUserDetails.class);
	private User user;
	public CustomUserDetails(User user)
	{
		LOG.info("--------------->Constructor invoked");
		this.user=user;
	}
	public CustomUserDetails()
	{
		LOG.info("--------------->Constructor invoked");
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
