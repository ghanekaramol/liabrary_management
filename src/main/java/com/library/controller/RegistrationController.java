package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.message.Message;
import com.library.model.User;
import com.library.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/register")
	public ResponseEntity<Message> register(@RequestBody User user)
	{	
			userService.userRegistration(user);
			Message m = new Message();
			m.setMessage("User registered Successfully..!!");
			return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@PostMapping("/admin/removeRole")
	public ResponseEntity<String> removeRole(@RequestBody Integer id)
	{
			userService.removeRole(id);
			Message m = new Message();
			m.setMessage("Role is removed");
			return new ResponseEntity<>("Role is removed from selected user.",HttpStatus.OK);
	}
	
	@PostMapping("/admin/assignRole")
	public ResponseEntity<Message> assignRole(@RequestBody Integer id)
	{
			userService.assignRole(id);
			Message m =new Message();
			m.setMessage("Role is assigned..");
			return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/deleteUser")
	public ResponseEntity<Message> deleteStudent(@RequestBody Integer studentId)
	{
			userService.deleteStudent(studentId);
			Message m = new Message();
			m.setMessage("User deleted..");
			return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@PutMapping("/user/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		return new ResponseEntity<>(userService.updateStudent(user),HttpStatus.OK);
	}
	
}
