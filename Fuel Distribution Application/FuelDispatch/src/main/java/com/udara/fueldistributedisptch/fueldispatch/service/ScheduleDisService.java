package com.udara.fueldistributedisptch.fueldispatch.service;

import com.udara.fueldistributedisptch.fueldispatch.model.Schedule;

import java.time.LocalDate;

public interface ScheduleDisService {
    public void deleteSchedule(int orderRefId);
    //public Schedule getSchedule(int orderRefId, String fuelType, int qty, LocalDate scheduleDate);
}
