package com.udara.fuelapp.fueldistributionapp.service;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.repository.OrderRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepo orderRepo;

    @Override
    public ResponseEntity<Order> saveOrder(Order order) {
        Random random = new Random();
        int x  = random.nextInt(2500);
        try {
            order.setOrderRefId(x);
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
    @Override
    public ResponseEntity<Optional<Order>> getOrder(int id){
        return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findById(id));
    }
    @Override
    public ResponseEntity<Order> orderReceived(int id){
        Optional<Order> selectedOrder= orderRepo.findById(id);
        if(selectedOrder.isPresent()){
            Order order=selectedOrder.get();
            order.setStatus("Completed");
            orderRepo.save(order);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
