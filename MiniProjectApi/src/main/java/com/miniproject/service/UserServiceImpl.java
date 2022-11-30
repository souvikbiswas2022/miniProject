package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.exception.UserException;
import com.miniproject.model.Admin;
import com.miniproject.model.User;
import com.miniproject.repository.AdminRepo;
import com.miniproject.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uR;

	@Override
	public User addUser(User user) throws UserException {

		Optional<User> checkExistance = uR.findById(user.getId());

		if (checkExistance.isPresent())
			throw new UserException("This user alreday present...!");

		else

			return uR.save(user);

	}

	@Override
	public User viewUser(User user) throws UserException {

		Optional<User> checkExistance = uR.findById(user.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new UserException("User not found...!");

	}

	@Override
	public List<User> viewAllUsers() throws UserException {

		List<User> allUser = uR.findAll();

		if (allUser.size() != 0)
			return allUser;
		else
			throw new UserException("No User found...!");

	}

	@Override
	public User updateUser(User user) throws UserException {

		Optional<User> checkExistance = uR.findById(user.getId());

		if (checkExistance.isPresent())
			return uR.save(user);

		else

			throw new UserException("Invalid User...!");

	}

	@Override
	public User removeUser(User user) throws UserException {

		
		Optional<User> checkExistance = uR.findById(user.getId());

		if (checkExistance.isPresent()) {
			uR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new UserException("Invalid User...!");
		
		}
	}

}
