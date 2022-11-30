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
import com.miniproject.exception.CategoryException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.model.User;
import com.miniproject.service.AdminService;
import com.miniproject.service.CategoryService;
import com.miniproject.service.UserService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cS;

	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException {

		Category resisteredCategory = cS.addCategory(category);

		return new ResponseEntity<Category>(resisteredCategory, HttpStatus.ACCEPTED);

	}

	@GetMapping("/categories")
	public ResponseEntity<Category> viewCategory(@RequestBody Category category) throws CategoryException {

		Category resisteredCategory = cS.viewCategory(category);

		return new ResponseEntity<Category>(resisteredCategory, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getcategories")
	ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {

		List<Category> allCategories = cS.viewAllCategory();

		return new ResponseEntity<List<Category>>(allCategories, HttpStatus.ACCEPTED);

	}

	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {

		Category updatedCategory = cS.updateCategory(category);

		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);

	}

	@DeleteMapping("/categories")
	public ResponseEntity<Category>  removeUser(@RequestBody Category category) throws CategoryException{
		
		Category removedCategory = cS.removeCategory(category);

		return new ResponseEntity<Category>(removedCategory, HttpStatus.ACCEPTED);
		

		
	}

}
