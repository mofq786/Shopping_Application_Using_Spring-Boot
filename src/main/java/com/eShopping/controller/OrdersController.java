package com.eShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShopping.entity.Cart;
import com.eShopping.entity.Orders;
import com.eShopping.service.CartService;
import com.eShopping.service.OrdersService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private CartService cartService;

    @RequestMapping("/myorders")
    public String showOrders(HttpServletRequest request, Model model) {
        try {
    	List<Orders> ordersList = ordersService.getOrdersList((Integer) request.getSession().getAttribute("custId"));
        
        if(ordersList.size() == 0)
        {
            return "OrdersNotFound";
        }
        model.addAttribute("ordersList", ordersList);
        return "MyOrders";
        }
        catch (Exception e) {
			return "redirect:/loginpage";
		}
    }
    
    @RequestMapping("/place-order")
    public String placeOrder(HttpServletRequest request, Model model)
    {
    	int custId = (Integer)   (request.getSession().getAttribute("custId"));
    	List<Cart> cartList = cartService.getAllCart(custId);
    	List<Orders> ordersList = ordersService.saveOrdersList(cartList);
    	
    	if(ordersList.size()!=0)
    	{
    		model.addAttribute("ordersList", ordersList);
    		return "MyOrders";
    	}
    	
    	return "OrderError";
    }

}
