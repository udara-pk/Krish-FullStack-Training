package com.udara.fuelapp.fueldistributionapp.service;

import com.udara.fuelapp.fueldistributionapp.config.KafkaTopicConfig;
import com.udara.fuelapp.fueldistributionapp.model.Order;
import com.udara.fuelapp.fueldistributionapp.repository.OrderRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public ResponseEntity<Order> saveOrder(Order order) {
        Random random = new Random();
        int x  = random.nextInt(2500);
        try {
            order.setOrderRefId(x);
            kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC, order);
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
    public ResponseEntity<List<Order>> getSpecificOrder(int shedId){
        return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findByShedId(shedId));
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

    @Override
    public ResponseEntity<Order> orderReceived1(int id){
        Optional<Order> selectedOrder1= orderRepo.findById(id);
        if(selectedOrder1.isPresent()){
            Order order=selectedOrder1.get();
            order.setStatus("Completed");
            orderRepo.save(order);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Order update with status
    @Override
    public ResponseEntity<Order> orderStatusUpdated(int id, String status) {

        Optional<Order> byId = orderRepo.findById(id);
        if(byId.isPresent()) {
            Order order = byId.get();
            order.setStatus(status);

            orderRepo.save(order);

            return ResponseEntity.status(HttpStatus.OK).body(order);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
