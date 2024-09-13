package com.eShopping.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eShopping.entity.ProductDetails;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductDetails, Integer>
{
	
	ProductDetails findByProductid(int productid);
	@Query("select productdetails from ProductDetails productdetails "
			+ "where productdetails.brand=?1 or productdetails.category=?1 "
			+ "or productdetails.productname=?1 ")
	List<ProductDetails> readByBrandOrCategoryOrProductname(String filterby);

}
