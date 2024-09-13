package com.eShopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.entity.Cart;
import com.eShopping.repository.CartRepository;

@Component
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addProducrIntoCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public boolean deleteProductsFromCart(int cartId) {
		cartRepository.deleteById(cartId);
		if(getById(cartId) == null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public List<Cart> getAllCartProducts(int custId) {
		return cartRepository.findByCustomerid(custId);
	}
	
	private Cart getById(int cartId)
	{
		return cartRepository.findByCartid(cartId);
	}

}
