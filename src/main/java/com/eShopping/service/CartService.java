package com.eShopping.service;

import java.util.List;

import com.eShopping.entity.Cart;
import com.eShopping.entity.ProductDetails;

public interface CartService {
	Cart addProductIntoCart(ProductDetails productDetails, int custId);
	boolean deleteProductFromCart(int cartId);
	List<Cart> getAllCart(int custId);
}
