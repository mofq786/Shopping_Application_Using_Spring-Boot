package com.eShopping.service;

import java.util.List;

import com.eShopping.entity.Cart;
import com.eShopping.entity.Orders;

public interface OrdersService {

    List<Orders> getOrdersList(int custId);
    List<Orders> saveOrdersList(List<Cart> cartList);
}
