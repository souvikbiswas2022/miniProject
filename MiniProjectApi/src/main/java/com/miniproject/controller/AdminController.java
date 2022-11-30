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
import com.miniproject.model.Admin;
import com.miniproject.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService aS;

	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminException {

		Admin resisteredAdmin = aS.addAdmin(admin);

		return new ResponseEntity<Admin>(resisteredAdmin, HttpStatus.ACCEPTED);

	}

	@GetMapping("/admins")
	public ResponseEntity<Admin> viewAdmin(@RequestBody Admin admin) throws AdminException {

		Admin resisteredAdmin = aS.viewAdmin(admin);

		return new ResponseEntity<Admin>(resisteredAdmin, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getadmins")
	ResponseEntity<List<Admin>> viewAllAdmin() throws AdminException {

		List<Admin> allAdmins = aS.viewAllAdmin();

		return new ResponseEntity<List<Admin>>(allAdmins, HttpStatus.ACCEPTED);

	}

	@PutMapping("/admins")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws AdminException {

		Admin updatedAdmin = aS.updateAdmin(admin);

		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);

	}

	@DeleteMapping("/admins")
	public ResponseEntity<Admin>  removeAdmin(@RequestBody Admin admin) throws AdminException{
		
		Admin removedAdmin = aS.removeAdmin(admin);

		return new ResponseEntity<Admin>(removedAdmin, HttpStatus.ACCEPTED);
		

		
	}

}
