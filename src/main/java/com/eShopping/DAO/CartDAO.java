package com.eShopping.DAO;

import java.util.List;

import com.eShopping.entity.Cart;

public interface CartDAO {
	Cart addProducrIntoCart(Cart cart);
	boolean deleteProductsFromCart(int cartId);
	List<Cart> getAllCartProducts(int custId);
}
