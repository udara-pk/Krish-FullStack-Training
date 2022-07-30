package com.udara.fuelapp.fueldistributionapp.service;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public ResponseEntity<Order> saveOrder(Order order);
    public ResponseEntity<List<Order>> getAllOrders();
}
