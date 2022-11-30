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
import com.miniproject.exception.OrderException;
import com.miniproject.exception.ProductException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.model.Order;
import com.miniproject.model.Product;
import com.miniproject.model.User;
import com.miniproject.service.AdminService;
import com.miniproject.service.CategoryService;
import com.miniproject.service.OrderService;
import com.miniproject.service.ProductService;
import com.miniproject.service.UserService;

@RestController
public class OrderController {

	@Autowired
	private OrderService oS;

	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderException {

		Order resisteredOrder = oS.addOrder(order);

		return new ResponseEntity<Order>(resisteredOrder, HttpStatus.ACCEPTED);

	}

	@GetMapping("/orders")
	public ResponseEntity<Order> viewProduct(@RequestBody Order order) throws OrderException {

		Order resisteredOrder = oS.viewOrder(order);

		return new ResponseEntity<Order>(resisteredOrder, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getorders")
	ResponseEntity<List<Order>> viewAllOrder() throws OrderException {

		List<Order> allOrder = oS.viewAllOrder();

		return new ResponseEntity<List<Order>>(allOrder, HttpStatus.ACCEPTED);

	}

	@PutMapping("/orders")
	public ResponseEntity<Order> updateProduct(@RequestBody Order order) throws OrderException {

		Order updatedOrder = oS.updateOrder(order);

		return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);

	}

	@DeleteMapping("/orders")
	public ResponseEntity<Order>  removeProduct(@RequestBody Order order) throws OrderException{
		
		Order removedOrder = oS.removeOrder(order);

		return new ResponseEntity<Order>(removedOrder, HttpStatus.ACCEPTED);
		

		
	}

}
