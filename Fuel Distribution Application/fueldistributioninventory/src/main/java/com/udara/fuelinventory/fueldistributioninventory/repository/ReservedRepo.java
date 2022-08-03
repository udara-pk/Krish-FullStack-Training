package com.udara.fuelinventory.fueldistributioninventory.repository;

import com.udara.fuelinventory.fueldistributioninventory.model.Reserved;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedRepo extends MongoRepository<Reserved, Integer> {

}
