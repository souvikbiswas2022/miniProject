package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.OrderException;
import com.miniproject.model.Admin;
import com.miniproject.model.Order;
import com.miniproject.repository.AdminRepo;
import com.miniproject.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oR;

	@Override
	public Order addOrder(Order order) throws OrderException {

		Optional<Order> checkExistance = oR.findById(order.getId());

		if (checkExistance.isPresent())
			throw new OrderException("This order alreday present...!");

		else

			return oR.save(order);

	}

	@Override
	public Order viewOrder(Order order) throws OrderException {

		Optional<Order> checkExistance = oR.findById(order.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new OrderException("Order not found...!");

	}

	@Override
	public List<Order> viewAllOrder() throws OrderException {

		List<Order> allOrder = oR.findAll();

		if (allOrder.size() != 0)
			return allOrder;
		else
			throw new OrderException("No order found...!");

	}

	@Override
	public Order updateOrder(Order order) throws OrderException {

		Optional<Order> checkExistance = oR.findById(order.getId());

		if (checkExistance.isPresent())
			return oR.save(order);

		else

			throw new OrderException("Invalid order...!");

	}

	@Override
	public Order removeOrder(Order order) throws OrderException {

		
		Optional<Order> checkExistance = oR.findById(order.getId());

		if (checkExistance.isPresent()) {
			oR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new OrderException("Invalid order...!");
		
		}
	}

}
