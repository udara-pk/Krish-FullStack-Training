package com.udara.fuelapp.fueldistributionapp.repository;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends MongoRepository<Order,Integer>{
    public List<Order> findByShedId(int shedId);
}
