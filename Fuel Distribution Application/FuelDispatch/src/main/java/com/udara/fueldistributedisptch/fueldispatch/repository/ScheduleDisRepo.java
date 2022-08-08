package com.udara.fueldistributedisptch.fueldispatch.repository;

import com.udara.fueldistributedisptch.fueldispatch.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDisRepo extends MongoRepository<Schedule, Integer> {
    Schedule findByOrderRefId(int id);
}
