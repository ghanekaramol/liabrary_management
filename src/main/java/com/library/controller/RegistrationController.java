package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.model.User;
import com.library.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/register")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		try {	
		if(user!=null)
		{
			
			userService.userRegistration(user);
			return new ResponseEntity<>("Registered Successfully !!", HttpStatus.OK);
	}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Registration failed !!", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/admin/removeRole")
	public ResponseEntity<String> removeRole(@RequestBody Integer id)
	{
		try {
			userService.removeRole(id);
			return new ResponseEntity<>("Role is removed from selected user.",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Role can't be removed.",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/admin/assignRole")
	public ResponseEntity<String> assignRole(@RequestBody Integer id)
	{
		try {
			userService.removeRole(id);
			return new ResponseEntity<>("Student role is assigned to selected user.",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Role can't be assigned.",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/admin/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestBody Integer studentId)
	{
		try {
			userService.deleteStudent(studentId);
			return new ResponseEntity<>("User deleted!!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("User deletion failed !!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
