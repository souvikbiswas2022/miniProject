package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CartItemException;
import com.miniproject.exception.CategoryException;
import com.miniproject.model.Admin;
import com.miniproject.model.CartItem;
import com.miniproject.model.Category;
import com.miniproject.repository.AdminRepo;
import com.miniproject.repository.CartItemRepo;
import com.miniproject.repository.CategoryRepo;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepo ciR;

	@Override
	public CartItem addCartItem(CartItem cartItem) throws CartItemException {

		Optional<CartItem> checkExistance = ciR.findById(cartItem.getId());

		if (checkExistance.isPresent())
			throw new CartItemException("This cart item alreday present...!");

		else

			return ciR.save(cartItem);

	}

	@Override
	public CartItem viewCartItem(CartItem cartItem) throws CartItemException {

		Optional<CartItem> checkExistance = ciR.findById(cartItem.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new CartItemException("Cart item not found...!");

	}

	@Override
	public List<CartItem> viewAllCartItem() throws CartItemException {

		List<CartItem> allCartItem = ciR.findAll();

		if (allCartItem.size() != 0)
			return allCartItem;
		else
			throw new CartItemException("No cart item found...!");

	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) throws CartItemException {

		Optional<CartItem> checkExistance = ciR.findById(cartItem.getId());

		if (checkExistance.isPresent())
			return ciR.save(cartItem);

		else

			throw new CartItemException("Invalid cart item...!");

	}

	@Override
	public CartItem removeCartItem(CartItem cartItem) throws CartItemException {

		
		Optional<CartItem> checkExistance = ciR.findById(cartItem.getId());

		if (checkExistance.isPresent()) {
			ciR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new CartItemException("Invalid cart item...!");
		
		}
	}

}
