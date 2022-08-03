package com.udara.fuelinventory.fueldistributioninventory.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udara.fuelinventory.fueldistributioninventory.model.Order;
import com.udara.fuelinventory.fueldistributioninventory.service.AvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    AvailableService availableService;



    @KafkaListener(topics = "order_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<Order> data){

        String value = String.valueOf(data);
        String fuelType = "";
        String OrderStatus = "";
        int OrderRefId = 0;
        int fuelCapacity = 0;

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Order> listCar = objectMapper.readValue(value, new TypeReference<List<Order>>(){});
            for(Order model : listCar) {
                System.out.println(model.getCapacity());
                fuelType = model.getFuelType();
                fuelCapacity = model.getCapacity();
                OrderStatus = model.getStatus();
                OrderRefId  = model.getOrderRefId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(availableService.getCapacity(fuelType,fuelCapacity,OrderRefId));

    }
}