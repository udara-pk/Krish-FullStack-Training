package com.udara.fuelapp.fueldistributionapp.controller;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/getallorders/addnew")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping("/getorders/{id}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable int id){

        return orderService.getOrder(id);
    }

    @GetMapping("/getorder/{shedId}")
    public ResponseEntity<List<Order>> getSpecificOrder(@PathVariable int shedId){
        return orderService.getSpecificOrder(shedId);
    }

    //Orders page
    @PutMapping("/getallorders/orderreceived/{id}")
    public ResponseEntity<Order> orderReceived(@PathVariable int id) {

        return orderService.orderReceived(id);
    }

    //specific order page
    @PutMapping("/getorder/orderreceived/{id}")
    public ResponseEntity<Order> orderReceived1(@PathVariable int id) {

        return orderService.orderReceived1(id);
    }
    @GetMapping("/getallorders")
    public ResponseEntity<List<Order>> getAllOrders(){

        return orderService.getAllOrders();
    }


}
