package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.model.Admin;

public interface AdminService {

	
	
	 Admin addAdmin(Admin admin) throws AdminException;
	 
	 Admin viewAdmin(Admin admin) throws AdminException;
	 
	 List<Admin> viewAllAdmin() throws AdminException;
	 
	 Admin updateAdmin(Admin admin) throws AdminException;
	 
	 Admin removeAdmin(Admin admin) throws AdminException;
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
