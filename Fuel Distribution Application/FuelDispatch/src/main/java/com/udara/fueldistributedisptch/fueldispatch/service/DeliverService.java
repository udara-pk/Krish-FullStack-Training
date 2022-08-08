package com.udara.fueldistributedisptch.fueldispatch.service;

import com.udara.fueldistributedisptch.fueldispatch.model.Deliver;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface DeliverService {
    public Deliver saveDeliver(Deliver deliver);
    public Deliver getFromSchedule(int orderRefId, String fuelType, int qty);
    public ResponseEntity<List<Deliver>> getAllDeliver();
    public ResponseEntity<Deliver> deliverStatusUpdated(int id, String status);


}
