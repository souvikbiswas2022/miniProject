package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Admin;
import com.miniproject.model.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

	
	
	
	
}
