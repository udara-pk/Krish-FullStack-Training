package com.udara.fueldisribschedule.fuelschedule.repository;

import com.udara.fueldisribschedule.fuelschedule.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepo extends MongoRepository<Schedule, Integer> {

}
