package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CategoryException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;

public interface CategoryService {

	
	
	 Category addCategory(Category category) throws CategoryException;
	 
	 Category viewCategory(Category category) throws CategoryException;
	 
	 List<Category> viewAllCategory() throws CategoryException;
	 
	 Category updateCategory(Category category) throws CategoryException;
	 
	 Category removeCategory(Category category) throws CategoryException;
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
