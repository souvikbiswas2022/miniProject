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
import com.miniproject.exception.CartItemException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.CartItem;
import com.miniproject.model.User;
import com.miniproject.service.AdminService;
import com.miniproject.service.CartItemService;
import com.miniproject.service.UserService;

@RestController
public class CartItemController {

	@Autowired
	private CartItemService ciS;

	@PostMapping("/cartitems")
	public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) throws CartItemException {

		CartItem resisteredCartItem = ciS.addCartItem(cartItem);

		return new ResponseEntity<CartItem>(resisteredCartItem, HttpStatus.ACCEPTED);

	}

	@GetMapping("/cartitems")
	public ResponseEntity<CartItem> viewCartItem(@RequestBody CartItem cartItem) throws CartItemException {

		CartItem resisteredCartItem = ciS.viewCartItem(cartItem);

		return new ResponseEntity<CartItem>(resisteredCartItem, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getcartitems")
	ResponseEntity<List<CartItem>> viewAllCartItem() throws CartItemException {

		List<CartItem> allCartItem = ciS.viewAllCartItem();

		return new ResponseEntity<List<CartItem>>(allCartItem, HttpStatus.ACCEPTED);

	}

	@PutMapping("/cartitems")
	public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem) throws CartItemException {

		CartItem updatedCartItem = ciS.updateCartItem(cartItem);

		return new ResponseEntity<CartItem>(updatedCartItem, HttpStatus.OK);

	}

	@DeleteMapping("/cartitems")
	public ResponseEntity<CartItem>  removeCartItem(@RequestBody CartItem cartItem) throws CartItemException{
		
		CartItem removedCartItem = ciS.removeCartItem(cartItem);

		return new ResponseEntity<CartItem>(removedCartItem, HttpStatus.ACCEPTED);
		

		
	}

}
