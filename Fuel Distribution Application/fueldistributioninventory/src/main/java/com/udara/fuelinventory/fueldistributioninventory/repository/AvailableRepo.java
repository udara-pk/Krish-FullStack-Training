package com.udara.fuelinventory.fueldistributioninventory.repository;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableRepo extends MongoRepository<Available, Integer> {
    Available findByFuelType(String type);
}