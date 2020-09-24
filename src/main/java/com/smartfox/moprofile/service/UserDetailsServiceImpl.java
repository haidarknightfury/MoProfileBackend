package com.smartfox.moprofile.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartfox.moprofile.config.MoProfileUser;
import com.smartfox.moprofile.model.User;
import com.smartfox.moprofile.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {// so can check whether username and password matches the authentication
		User user =  this.userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username + "not found"));
		return MoProfileUser.build(user);
	}

}
