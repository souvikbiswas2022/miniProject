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
import com.miniproject.exception.ProductException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.model.Product;
import com.miniproject.model.User;
import com.miniproject.service.AdminService;
import com.miniproject.service.CategoryService;
import com.miniproject.service.ProductService;
import com.miniproject.service.UserService;

@RestController
public class ProductController {

	@Autowired
	private ProductService pS;

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException {

		Product resisteredProduct = pS.addProduct(product);

		return new ResponseEntity<Product>(resisteredProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/products")
	public ResponseEntity<Product> viewProduct(@RequestBody Product product) throws ProductException {

		Product resisteredProduct = pS.viewProduct(product);

		return new ResponseEntity<Product>(resisteredProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getproducts")
	ResponseEntity<List<Product>> viewAllProduct() throws ProductException {

		List<Product> allProducts = pS.viewAllProduct();

		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.ACCEPTED);

	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException {

		Product updatedProduct = pS.updateProduct(product);

		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/products")
	public ResponseEntity<Product>  removeProduct(@RequestBody Product product) throws ProductException{
		
		Product removedProduct = pS.removeProduct(product);

		return new ResponseEntity<Product>(removedProduct, HttpStatus.ACCEPTED);
		

		
	}

}
