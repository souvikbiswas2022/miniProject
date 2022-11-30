package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.exception.AdminException;
import com.miniproject.model.Admin;
import com.miniproject.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo aR;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {

		Optional<Admin> checkExistance = aR.findById(admin.getId());

		if (checkExistance.isPresent())
			throw new AdminException("This admin alreday present...!");

		else

			return aR.save(admin);

	}

	@Override
	public Admin viewAdmin(Admin admin) throws AdminException {

		Optional<Admin> checkExistance = aR.findById(admin.getId());

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new AdminException("Admin not found...!");

	}

	@Override
	public List<Admin> viewAllAdmin() throws AdminException {

		List<Admin> allAdmins = aR.findAll();

		if (allAdmins.size() != 0)
			return allAdmins;
		else
			throw new AdminException("No admin found...!");

	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {

		Optional<Admin> checkExistance = aR.findById(admin.getId());

		if (checkExistance.isPresent())
			return aR.save(admin);

		else

			throw new AdminException("Invalid Admin...!");

	}

	@Override
	public Admin removeAdmin(Admin admin) throws AdminException {

		
		Optional<Admin> checkExistance = aR.findById(admin.getId());

		if (checkExistance.isPresent()) {
			aR.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new AdminException("Invalid Admin...!");
		
		}
	}

}
