package com.library.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public void userRegistration(User user)
	{
		Set<Role> roles = new HashSet<>();
		
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void deleteStudent(Integer studentId) {
		
		userRepository.deleteById(studentId);
		
	}
	
	public User updateStudent(User user)
	{
		
		User userDb = userRepository.findByEmailid(user.getEmailid());
		userDb.setFirstName(user.getFirstName());
		userDb.setLastName(user.getLastName());
		userDb.setEmailid(user.getEmailid());
		userDb.setPassword(user.getPassword());
		
		return userRepository.save(userDb);
		
	}
	
	public User removeRole(Integer id) throws Exception
	{
		User user = userRepository.findById(id).get();
		if(id == user.getId())
		{
		user.setRoles(null);
		return userRepository.save(user);
		}
		else {
			throw new Exception("User's role is removed already.") ;
		}
	}
	
	public User assignRole(Integer id)
	{
		User user = userRepository.findById(id).get();
		Set<Role> roles = new HashSet<>();
		
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		return userRepository.save(user);
	}
	
}
