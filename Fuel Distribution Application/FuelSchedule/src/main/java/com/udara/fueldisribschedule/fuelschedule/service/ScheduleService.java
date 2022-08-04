package com.udara.fueldisribschedule.fuelschedule.service;

import com.udara.fueldisribschedule.fuelschedule.model.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {
    public ResponseEntity<Schedule> saveSchedule(Schedule schedule);
    public ResponseEntity<List<Schedule>> getAllSchedule();
    public Schedule scheduleDate(int orderRefId,String fuelType, int fuelCapacity);
}
