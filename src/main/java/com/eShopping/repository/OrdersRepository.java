package com.eShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eShopping.entity.Orders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerid(int customerId);
}
