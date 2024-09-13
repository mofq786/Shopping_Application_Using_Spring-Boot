package com.eShopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.entity.Admin;
import com.eShopping.repository.AdminRepository;
@Component
public class AdminDAOImpl implements AdminDAO
{
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin adminLogin(String emailid, String password) {
		 return adminRepository.readByAdminemailidAndAdminpassword(emailid, password);  
	}

}
