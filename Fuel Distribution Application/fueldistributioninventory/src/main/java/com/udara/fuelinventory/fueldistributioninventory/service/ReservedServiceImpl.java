package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Reserved;
import com.udara.fuelinventory.fueldistributioninventory.repository.ReservedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedServiceImpl implements ReservedService{

    @Autowired
    ReservedRepo reservedRepo;

    @Override
    public Reserved saveReserved(Reserved reserved) {

        return reservedRepo.save(reserved);
    }

    @Override
    public Reserved getFromAvailable(int orderRefId, String fuelType, int fuelCapacity) {
        Reserved reserved = new Reserved();
        reserved.setOrderRefId(orderRefId);
        reserved.setFuelType(fuelType);
        reserved.setQty(fuelCapacity);
        return saveReserved(reserved);


    }
}