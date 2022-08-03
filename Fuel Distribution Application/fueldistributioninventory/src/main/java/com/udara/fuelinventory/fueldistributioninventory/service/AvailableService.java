package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import org.springframework.http.ResponseEntity;

public interface AvailableService {
    public ResponseEntity<Available> saveAvailableFuel(Available available);
    //public ResponseEntity<Available> updateAvailableFuel(@PathVariable String fuelType);
    public Available getCapacity( String fuelType, int fuelCapacity,int orderRefeId);
}
