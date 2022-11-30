package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CategoryException;
import com.miniproject.exception.ProductException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.model.Product;
import com.miniproject.repository.AdminRepo;
import com.miniproject.repository.CategoryRepo;
import com.miniproject.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo pR;

	@Override
	public Product addProduct(Product product) throws ProductException {

		Optional<Product> checkExistance = pR.findById(product.getId());

		if (checkExistance.isPresent())
			throw new ProductException("This product alreday present...!");

		else

			return pR.save(product);

	}

	@Override
	public Product viewProduct(Product product) throws ProductException {

		Optional<Product> checkExistance = pR.findById(product.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new ProductException("Product not found...!");

	}

	@Override
	public List<Product> viewAllProduct() throws ProductException {

		List<Product> allProduct = pR.findAll();

		if (allProduct.size() != 0)
			return allProduct;
		else
			throw new ProductException("No product found...!");

	}

	@Override
	public Product updateProduct(Product product) throws ProductException {

		Optional<Product> checkExistance = pR.findById(product.getId());

		if (checkExistance.isPresent())
			return pR.save(product);

		else

			throw new ProductException("Invalid product...!");

	}

	@Override
	public Product removeProduct(Product product) throws ProductException {

		
		Optional<Product> checkExistance = pR.findById(product.getId());

		if (checkExistance.isPresent()) {
			pR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new ProductException("Invalid product...!");
		
		}
	}

}
