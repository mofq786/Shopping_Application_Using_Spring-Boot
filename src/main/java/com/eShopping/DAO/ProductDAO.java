package com.eShopping.DAO;

import java.util.List;

import com.eShopping.entity.ProductDetails;

public interface ProductDAO {
	
	ProductDetails insertProductDetails(ProductDetails productDetails);
	List<ProductDetails> allProductDetails();
	ProductDetails getProductById(int id);
	ProductDetails updateProducts(ProductDetails productDetails);
	List<ProductDetails> filterProducts(String filterby);
	boolean deleteProductById(int id);

}
