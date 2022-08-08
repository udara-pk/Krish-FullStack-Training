package com.udara.fueldistributedisptch.fueldispatch.service;

import com.udara.fueldistributedisptch.fueldispatch.config.KafkaSchedule;
import com.udara.fueldistributedisptch.fueldispatch.model.Deliver;
import com.udara.fueldistributedisptch.fueldispatch.repository.DeliverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeliverServiceImpl implements DeliverService{

    @Autowired
    DeliverRepo deliverRepo;

    @Autowired
    KafkaTemplate<String, Deliver> kafkaTemplate;

    @Override
    public Deliver saveDeliver(Deliver deliver) {
        kafkaTemplate.send(KafkaSchedule.MESSAGE_TOPIC,deliver);
        return deliverRepo.save(deliver);
    }

    @Override
    public Deliver getFromSchedule(int orderRefId, String fuelType, int qty) {
        Deliver deliver = new Deliver();
        deliver.setOrderRefId(orderRefId);
        deliver.setFuelType(fuelType);
        deliver.setQty(qty);
        deliver.setStatus("Delivered");
        return saveDeliver(deliver);
    }

    @Override
    public ResponseEntity<List<Deliver>> getAllDeliver() {
        List<Deliver> orderEntity = 	deliverRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderEntity);
    }

    @Override
    public ResponseEntity<Deliver> deliverStatusUpdated(int id, String status){
        Optional<Deliver> byId = deliverRepo.findById(id);
        if(byId.isPresent()) {
            Deliver deliver = byId.get();
            deliver.setStatus(status);

            deliverRepo.save(deliver);

            return ResponseEntity.status(HttpStatus.OK).body(deliver);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
