package com.eShopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.DAO.CustomerDAO;
import com.eShopping.DAO.OrdersDAO;
import com.eShopping.entity.Cart;
import com.eShopping.entity.CustomerDetails;
import com.eShopping.entity.Orders;

@Component
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;
    
    @Autowired
    private CustomerDAO custDao;
    
    @Override
    public List<Orders> getOrdersList(int custId) {
        return ordersDAO.getAllOrdersList( custId );
    }
    
	@Override
	public List<Orders> saveOrdersList(List<Cart> cartList) {
		
		List<Orders> ordersList = new ArrayList<>();
		
		double totalSum = 0;
		
		for (Cart cart : cartList) {
			totalSum +=cart.getTotalamount();
		}
		
		CustomerDetails customer = custDao.getCustomerDetails(cartList.get(0).getCustomerid());
		
		for (Cart cart : cartList) {
			Orders order = new Orders();
			order.setBill(totalSum);
			order.setCustomerid(cart.getCustomerid());
			order.setProductid(cart.getProductid());
			order.setStatus(true);
			order.setAddress(customer.getAddress());	
			ordersList.add(order);
		}
		
		return ordersDAO.addOrdersList(ordersList);
		
	}
}