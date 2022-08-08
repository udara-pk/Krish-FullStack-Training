package com.udara.fueldistributedisptch.fueldispatch.controller;

import com.udara.fueldistributedisptch.fueldispatch.service.ScheduleDisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScheduleDisController {
    @Autowired
    ScheduleDisService scheduleDisService;

    @DeleteMapping("/allschedule/deliver/{id}")
    public void deleteSchedule(@PathVariable int id){
        scheduleDisService.deleteSchedule(id);
    }
}
