package com.udara.fueldistributedisptch.fueldispatch.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udara.fueldistributedisptch.fueldispatch.model.Order;
import com.udara.fueldistributedisptch.fueldispatch.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {
    @Autowired
    DeliverService deliverService;



    @KafkaListener(topics = "complete_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<Order> data){

        String value = String.valueOf(data);
        int orderRefId = 0;
        String status = "Completed";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Order> orders = objectMapper.readValue(value, new TypeReference<List<Order>>(){});
            for(Order order : orders) {
                orderRefId  = order.getOrderRefId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        deliverService.deliverStatusUpdated(orderRefId, status);

    }
}
