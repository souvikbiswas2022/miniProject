package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.CategoryException;
import com.miniproject.model.Admin;
import com.miniproject.model.Category;
import com.miniproject.repository.AdminRepo;
import com.miniproject.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo cR;

	@Override
	public Category addCategory(Category category) throws CategoryException {

		Optional<Category> checkExistance = cR.findById(category.getId());

		if (checkExistance.isPresent())
			throw new CategoryException("This category alreday present...!");

		else

			return cR.save(category);

	}

	@Override
	public Category viewCategory(Category category) throws CategoryException {

		Optional<Category> checkExistance = cR.findById(category.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new CategoryException("Category not found...!");

	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {

		List<Category> allCategory = cR.findAll();

		if (allCategory.size() != 0)
			return allCategory;
		else
			throw new CategoryException("No category found...!");

	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {

		Optional<Category> checkExistance = cR.findById(category.getId());

		if (checkExistance.isPresent())
			return cR.save(category);

		else

			throw new CategoryException("Invalid category...!");

	}

	@Override
	public Category removeCategory(Category category) throws CategoryException {

		
		Optional<Category> checkExistance = cR.findById(category.getId());

		if (checkExistance.isPresent()) {
			cR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new CategoryException("Invalid category...!");
		
		}
	}

}
