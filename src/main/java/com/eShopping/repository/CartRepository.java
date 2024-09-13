package com.eShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eShopping.entity.Cart;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByCustomerid(int customerid);
	Cart findByCartid(int cartid);

}
