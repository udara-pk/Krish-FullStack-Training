package com.udara.fueldistributedisptch.fueldispatch.service;

import com.udara.fueldistributedisptch.fueldispatch.model.Schedule;
import com.udara.fueldistributedisptch.fueldispatch.repository.ScheduleDisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ScheduleDisServiceImpl implements ScheduleDisService{
    @Autowired
    ScheduleDisRepo scheduleDisRepo;

    @Autowired
    DeliverService deliverService;

    @Override
    public void deleteSchedule(int orderRefId){
        Schedule byOrderRefId=scheduleDisRepo.findByOrderRefId(orderRefId);
        String fuelType=byOrderRefId.getFuelType();
        int qty=byOrderRefId.getQty();
        LocalDate scheduleDate=byOrderRefId.getScheduleDate();
        deliverService.getFromSchedule(orderRefId,fuelType,qty);
        scheduleDisRepo.deleteById(orderRefId);
    }

    /*@Override
    public Schedule getSchedule(int orderRefId, String fuelType, int qty, LocalDate scheduleDate){
        Schedule byOrderRefId=scheduleDisRepo.findByOrderRefId(orderRefId);
    }*/


}
