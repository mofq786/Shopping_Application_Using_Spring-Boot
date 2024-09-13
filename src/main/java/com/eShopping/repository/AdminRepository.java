package com.eShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eShopping.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	
	Admin readByAdminemailidAndAdminpassword(String emailid,
			String password);

}
