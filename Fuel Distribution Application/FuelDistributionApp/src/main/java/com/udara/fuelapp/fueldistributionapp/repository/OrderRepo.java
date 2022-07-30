package com.udara.fuelapp.fueldistributionapp.repository;

import com.udara.fuelapp.fueldistributionapp.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends MongoRepository<Order,Integer>{

}
