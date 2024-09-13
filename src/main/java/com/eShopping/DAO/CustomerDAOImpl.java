package com.eShopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.entity.CustomerDetails;
import com.eShopping.repository.CustomerRepository;
@Component
public class CustomerDAOImpl implements CustomerDAO
{
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public CustomerDetails insertCustomerObject(CustomerDetails customerDetails) {
		return customerRepository.save(customerDetails);	
	}
	@Override
	public CustomerDetails customerLogin(String emailid, String password) {
		return customerRepository.getByEmailidAndPassword(emailid, password);	
	}
	@Override
	public CustomerDetails getCustomerDetails(int custId) {
		return customerRepository.getReferenceById(custId);
	}

}
