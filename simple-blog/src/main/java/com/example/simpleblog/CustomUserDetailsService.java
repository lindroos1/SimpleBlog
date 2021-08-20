package com.example.simpleblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.simpleblog.User.Repository.UserRepository;
import com.example.simpleblog.models.CustomUserDetails;
import com.example.simpleblog.models.UserEntity;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		UserEntity user = userRepository.getUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("could not find the user");
		else
			return new CustomUserDetails(user);
	} 
}
 		