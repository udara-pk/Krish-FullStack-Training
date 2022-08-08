package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Reserved;

public interface ReservedService {
    public Reserved saveReserved(Reserved reserved);
    public Reserved getFromAvailable(int orderRefId, String fuelType, int fuelCapacity);
}
