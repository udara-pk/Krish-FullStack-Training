package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import com.udara.fuelinventory.fueldistributioninventory.model.Order;
import com.udara.fuelinventory.fueldistributioninventory.repository.AvailableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class AvailableServiceImpl implements AvailableService {

    @Autowired
    AvailableRepo availableRepo;

    @Autowired
    ReservedService reservedService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<Available> saveAvailableFuel(Available available) {
        try {
            availableRepo.save(available);

        }catch(Exception e) {

        }

        return ResponseEntity.status(HttpStatus.OK).body(available);
    }

    @Override
    public Available getCapacity(String fuelType, int fuelCapacity,int orderRefeId) {


        Available byFuelType = availableRepo.findByFuelType(fuelType);
        int availableCapacity = byFuelType.getQty();
        if(availableCapacity>=fuelCapacity){

            updateStatus(orderRefeId, "Allocated");
            int newAvailableCapacity  = availableCapacity - fuelCapacity;
            byFuelType.setQty(newAvailableCapacity);
            saveAvailableFuel(byFuelType);
            reservedService.getFromAvailable(orderRefeId,fuelType,fuelCapacity);
        }

        return byFuelType;

    }

    public void updateStatus(int RefId , String status){
        restTemplate.put("http://order/getorder/orderreceived/"+RefId+"/"+status, Order.class);
    }

    @Override
    public void updateAvailableFuel(Available available){
       availableRepo.save(available);
    }

    @Override
    public List<Available> getAvailable(){
        return availableRepo.findAll();
    }

}