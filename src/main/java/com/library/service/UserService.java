package com.library.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dto.LoginDto;
import com.library.exception.DataNotFoundException;
import com.library.exception.UserRoleAssignException;
import com.library.exception.UserRoleException;
import com.library.model.Role;
import com.library.model.User;
import com.library.repository.RoleRepository;
import com.library.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository; 
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public void userRegistration(User user)
	{	
		Set<Role> roles = new HashSet<>();
		
		roles.add(roleRepository.findById(2).orElseThrow(() -> new DataNotFoundException()));
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//userRepository.findByEmailid(user.getEmailid()).setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void deleteStudent(Integer studentId) {
		if(userRepository.findById(studentId).get() == null)
		{
			throw new DataNotFoundException();
		}	
		userRepository.deleteById(studentId);
	}
	
	public User updateStudent(User user)
	{
		User userDb = userRepository.findByEmailid(user.getEmailid()).orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: "));
		userDb.setFirstName(user.getFirstName());
		userDb.setLastName(user.getLastName());
		userDb.setEmailid(user.getEmailid());
		userDb.setPassword(user.getPassword());
		
		return userRepository.save(userDb);
		
	}
	
	public User removeRole(Integer id)
	{
		User user = userRepository.findById(id).get();
		if(user.getRoles()==null)
		{
			throw new UserRoleException();
		}
		user.setRoles(null);
		return userRepository.save(user);
	}
	
	public User assignRole(Integer id)
	{
		User user = userRepository.findById(id).get();
		if(user.getRoles()!=null)
		{
			throw new UserRoleAssignException();
		}
		
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		return userRepository.save(user);
	}

	public void login(LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmailid(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}
