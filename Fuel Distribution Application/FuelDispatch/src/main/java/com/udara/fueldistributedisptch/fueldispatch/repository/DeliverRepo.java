package com.udara.fueldistributedisptch.fueldispatch.repository;

import com.udara.fueldistributedisptch.fueldispatch.model.Deliver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepo extends MongoRepository<Deliver, Integer> {
}
