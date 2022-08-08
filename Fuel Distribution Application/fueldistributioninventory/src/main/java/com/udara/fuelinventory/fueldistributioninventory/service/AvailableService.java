package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AvailableService {
    public ResponseEntity<Available> saveAvailableFuel(Available available);
    public void updateAvailableFuel(Available available);
    public List<Available> getAvailable();
    public Available getCapacity( String fuelType, int fuelCapacity,int orderRefeId);
}
