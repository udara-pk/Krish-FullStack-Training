package com.udara.fuelapp.fueldistributionapp.service;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.repository.OrderRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepo orderRepo;

    @Override
    public ResponseEntity<Order> saveOrder(Order order) {

        try {

            orderRepo.save(order);

        }catch(Exception e) {


        }

        return ResponseEntity.status(HttpStatus.OK).body(order);

    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderEntity = 	orderRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderEntity);
    }
}
