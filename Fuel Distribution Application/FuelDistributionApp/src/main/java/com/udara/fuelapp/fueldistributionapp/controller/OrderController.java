package com.udara.fuelapp.fueldistributionapp.controller;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping("/getorder/{id}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable int id){

        return orderService.getOrder(id);
    }

    @PutMapping("/orderreceived/{id}")
    public ResponseEntity<Order> orderReceived(@PathVariable int id) {

        return orderService.orderReceived(id);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<Order>> getAllOrders(){

        return orderService.getAllOrders();
    }


}
