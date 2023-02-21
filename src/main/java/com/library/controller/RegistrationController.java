package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<String> register(@RequestBody User user)
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
	
}
