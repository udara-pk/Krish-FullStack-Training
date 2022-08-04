package com.udara.fueldisribschedule.fuelschedule.service;

import com.udara.fueldisribschedule.fuelschedule.model.Schedule;
import com.udara.fueldisribschedule.fuelschedule.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService{

    @Autowired
    ScheduleRepo scheduleRepo;

    @Override
    public ResponseEntity<Schedule> saveSchedule(Schedule schedule){
        try {
            scheduleRepo.save(schedule);
        }catch (Exception e){

        }
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

    @Override
    public ResponseEntity<List<Schedule>> getAllSchedule() {
        List<Schedule> orderEntity = 	scheduleRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderEntity);
    }

    @Override
    public Schedule scheduleDate(int orderRefId,String fuelType, int fuelCapacity){
        Schedule schedule = new Schedule();
        schedule.setOrderRefId(orderRefId);
        schedule.setFuelType(fuelType);
        schedule.setQty(fuelCapacity);
        schedule.setScheduleDate(LocalDate.now().plusDays(1));
        schedule.setStatus("Scheduled");
        saveSchedule(schedule);
        return schedule;
    }
}
