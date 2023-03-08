package com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
		User user = userRepository.findByEmailid(emailid); 
		if(user == null)
		{
			throw new UsernameNotFoundException("Could not find the User..");
		}
		return new MyUserDetails(user);
	}	
}
