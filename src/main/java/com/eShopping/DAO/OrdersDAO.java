package com.eShopping.DAO;

import com.eShopping.entity.Orders;

import java.util.List;

public interface OrdersDAO {

    List<Orders> getAllOrdersList(int custId);
    List<Orders> addOrdersList(List<Orders> ordersList);

}
