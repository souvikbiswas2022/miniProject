package com.miniproject.service;

import java.util.List;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.OrderException;
import com.miniproject.model.Admin;
import com.miniproject.model.Order;

public interface OrderService {

	
	
	 Order addOrder(Order Order) throws OrderException;
	 
	 Order viewOrder(Order Order) throws OrderException;
	 
	 List<Order> viewAllOrder() throws OrderException;
	 
	 Order updateOrder(Order Order) throws OrderException;
	 
	 Order removeOrder(Order Order) throws OrderException;
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
