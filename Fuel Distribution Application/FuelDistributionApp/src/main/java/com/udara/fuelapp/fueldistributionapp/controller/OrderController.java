package com.udara.fuelapp.fueldistributionapp.controller;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return orderService.getAllOrders();
    }
}
