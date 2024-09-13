package com.eShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eShopping.DAO.ProductDAO;
import com.eShopping.entity.Cart;
import com.eShopping.entity.ProductDetails;
import com.eShopping.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/add-to-cart")
	public String addToCart(Integer productid, HttpServletRequest request) throws Exception
	{
		int custId = (Integer)   (request.getSession().getAttribute("custId"));
		
		ProductDetails productDetails = productDAO.getProductById(productid);
		
		Cart cart = cartService.addProductIntoCart(productDetails, custId);
		if(cart != null)
		{
			return "redirect:/searchproducts";
		}
		return "CartError";
	}
	
	@RequestMapping("/delete-from-cart")
	public String deleteFromCart(int cartid)
	{
		if(cartService.deleteProductFromCart(cartid))
		{
			return "redirect:/get-all-cart";
		}
		return "CartError";
	}
	
	@RequestMapping("/get-all-cart")
	public String getAllProducts(HttpServletRequest request, Model model)
	{
		
		try {
			int custId = (Integer) request.getSession().getAttribute("custId");
			List<Cart> cartList = cartService.getAllCart(custId);
			if(cartList.size() != 0)
			{
				model.addAttribute("cartList", cartList);
				return "CartDetails";
			}
			
			return "EmptyCart";
		}
		catch(NullPointerException e)
		{
			return "redirect:/loginpage";
		}
		
	}
}
