package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.config.KafkaTopicAlocation;
import com.udara.fuelinventory.fueldistributioninventory.config.KafkaTopicConfig;
import com.udara.fuelinventory.fueldistributioninventory.model.Reserved;
import com.udara.fuelinventory.fueldistributioninventory.repository.ReservedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservedServiceImpl implements ReservedService{

    @Autowired
    ReservedRepo reservedRepo;

    @Autowired
    KafkaTemplate<String, Reserved> kafkaTemplate;

    @Override
    public Reserved saveReserved(Reserved reserved) {
        kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC,reserved);
        kafkaTemplate.send(KafkaTopicAlocation.MESSAGE_TOPIC,reserved);
        return reservedRepo.save(reserved);
    }

    @Override
    public Reserved getFromAvailable(int orderRefId, String fuelType, int fuelCapacity) {
        Reserved reserved = new Reserved();
        reserved.setOrderRefId(orderRefId);
        reserved.setFuelType(fuelType);
        reserved.setQty(fuelCapacity);
        return saveReserved(reserved);


    }
}
