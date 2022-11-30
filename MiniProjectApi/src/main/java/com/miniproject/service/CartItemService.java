package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CartItemException;
import com.miniproject.model.Admin;
import com.miniproject.model.CartItem;

public interface CartItemService {

	
	
	CartItem addCartItem(CartItem cartItem) throws CartItemException;
	 
	CartItem viewCartItem(CartItem cartItem) throws CartItemException;
	 
	 List<CartItem> viewAllCartItem() throws CartItemException;
	 
	 CartItem updateCartItem(CartItem cartItem) throws CartItemException;
	 
	 CartItem removeCartItem(CartItem cartItem) throws CartItemException;
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
