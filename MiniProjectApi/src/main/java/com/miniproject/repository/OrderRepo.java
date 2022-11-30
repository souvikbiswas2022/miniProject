package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Admin;
import com.miniproject.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	
	
	
	
}
