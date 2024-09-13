package com.eShopping.DAO;

import com.eShopping.entity.Admin;

public interface AdminDAO {
	
	Admin adminLogin(String emailid,
			String password);

}
