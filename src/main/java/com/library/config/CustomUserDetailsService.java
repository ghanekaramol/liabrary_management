package com.library.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmailid(emailid).orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: "+ emailid));

		Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
		return new org.springframework.security.core.userdetails.User(user.getEmailid(),user.getPassword(),authorities);
	}

}
