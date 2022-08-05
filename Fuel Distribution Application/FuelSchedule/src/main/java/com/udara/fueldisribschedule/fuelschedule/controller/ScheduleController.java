package com.udara.fueldisribschedule.fuelschedule.controller;

import com.udara.fueldisribschedule.fuelschedule.model.Schedule;
import com.udara.fueldisribschedule.fuelschedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    

    @PostMapping("/schedule")
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }

    @GetMapping("/allschedule")
    public ResponseEntity<List<Schedule>> getAllSchedule(){

        return scheduleService.getAllSchedule();
    }

}
