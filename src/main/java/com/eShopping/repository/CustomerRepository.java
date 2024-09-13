package com.eShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eShopping.entity.CustomerDetails;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {
	CustomerDetails getByEmailidAndPassword(String emailid, String password);
}
