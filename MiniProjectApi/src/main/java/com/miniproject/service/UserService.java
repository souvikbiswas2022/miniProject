package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.User;

public interface UserService {

	
	
	User addUser(User User) throws UserException;
	 
	User viewUser(User User) throws UserException;
	 
	 List<User> viewAllUsers() throws UserException;
	 
	 User updateUser(User User) throws UserException;
	 
	 User removeUser(User User) throws UserException;
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
