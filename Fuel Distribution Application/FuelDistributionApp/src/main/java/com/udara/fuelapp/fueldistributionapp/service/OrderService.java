package com.udara.fuelapp.fueldistributionapp.service;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public ResponseEntity<Order> saveOrder(Order order);
    public ResponseEntity<List<Order>> getAllOrders();
    public ResponseEntity<Optional<Order>> getOrder(int id);
    public ResponseEntity<Order> orderReceived1(int id);
    public ResponseEntity<List<Order>> getSpecificOrder(int shedId);
    public ResponseEntity<Order> orderStatusUpdated(int id, String status);
}
