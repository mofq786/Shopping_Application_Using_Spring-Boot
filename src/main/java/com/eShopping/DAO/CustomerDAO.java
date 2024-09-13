package com.eShopping.DAO;

import com.eShopping.entity.CustomerDetails;

public interface CustomerDAO {

	CustomerDetails insertCustomerObject(CustomerDetails customerDetails);
	
	CustomerDetails getCustomerDetails(int custId);

	CustomerDetails customerLogin(String emailid, String password);
}
