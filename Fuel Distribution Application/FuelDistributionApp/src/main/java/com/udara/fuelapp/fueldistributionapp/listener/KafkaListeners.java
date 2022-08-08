package com.udara.fuelapp.fueldistributionapp.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udara.fuelapp.fueldistributionapp.model.Reserved;
import com.udara.fuelapp.fueldistributionapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {
    @Autowired
    OrderService orderService;



    @KafkaListener(topics = "allocation_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<Reserved> data){

        String value = String.valueOf(data);
        int orderRefId = 0;
        String status = "Allocated";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Reserved> orders = objectMapper.readValue(value, new TypeReference<List<Reserved>>(){});
            for(Reserved order : orders) {
                orderRefId  = order.getOrderRefId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        orderService.orderStatusUpdated(orderRefId, status);

    }
}
