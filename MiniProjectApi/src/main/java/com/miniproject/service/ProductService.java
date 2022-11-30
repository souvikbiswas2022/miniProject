package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CategoryException;
import com.miniproject.exception.ProductException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.model.Product;

public interface ProductService {

	
	
	Product addProduct(Product Product) throws ProductException;
	 
	Product viewProduct(Product Product) throws ProductException;
	 
	 List<Product> viewAllProduct() throws ProductException;
	 
	 Product updateProduct(Product Product) throws ProductException;
	 
	 Product removeProduct(Product Product) throws ProductException;
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
