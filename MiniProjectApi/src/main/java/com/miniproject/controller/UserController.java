package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.User;
import com.miniproject.service.AdminService;
import com.miniproject.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uS;

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException {

		User resisteredUser = uS.addUser(user);

		return new ResponseEntity<User>(resisteredUser, HttpStatus.ACCEPTED);

	}

	@GetMapping("/users")
	public ResponseEntity<User> viewUser(@RequestBody User user) throws UserException {

		User resisteredUser = uS.viewUser(user);

		return new ResponseEntity<User>(resisteredUser, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getusers")
	ResponseEntity<List<User>> viewAllUser() throws UserException {

		List<User> allAUsers = uS.viewAllUsers();

		return new ResponseEntity<List<User>>(allAUsers, HttpStatus.ACCEPTED);

	}

	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException {

		User updatedUser = uS.updateUser(user);

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

	}

	@DeleteMapping("/users")
	public ResponseEntity<User>  removeUser(@RequestBody User user) throws UserException{
		
		User removedUser = uS.removeUser(user);

		return new ResponseEntity<User>(removedUser, HttpStatus.ACCEPTED);
		

		
	}

}
