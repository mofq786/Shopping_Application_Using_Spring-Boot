package com.eShopping.DAO;

import com.eShopping.entity.Orders;
import com.eShopping.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public List<Orders> getAllOrdersList(int custId) {
        return ordersRepository.findByCustomerid(custId);
    }
	@Override
	public List<Orders> addOrdersList(List<Orders> ordersList) {
		return ordersRepository.saveAll(ordersList);
	}
}
