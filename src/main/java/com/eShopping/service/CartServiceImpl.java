package com.eShopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.DAO.CartDAO;
import com.eShopping.entity.Cart;
import com.eShopping.entity.ProductDetails;

@Component
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;

	@Override
	public Cart addProductIntoCart(ProductDetails productDetails, int custId ) {
		
		Cart cart = new Cart();
		cart.setCustomerid(custId);
		cart.setProductid(productDetails.getProductid());
		cart.setProductquantity(1);
		cart.setTotalamount(productDetails.getPrice());
		
		return cartDAO.addProducrIntoCart(cart);
		
	}

	@Override
	public boolean deleteProductFromCart(int cartId) {
		return cartDAO.deleteProductsFromCart(cartId);
	}

	@Override
	public List<Cart> getAllCart(int custId) {
		return cartDAO.getAllCartProducts(custId);
	}
	
	

}
