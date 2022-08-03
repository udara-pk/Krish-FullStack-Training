package com.udara.fuelinventory.fueldistributioninventory.service;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import com.udara.fuelinventory.fueldistributioninventory.model.Order;
import com.udara.fuelinventory.fueldistributioninventory.repository.AvailableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AvailableServiceImpl implements AvailableService {

    @Autowired
    AvailableRepo availableRepo;

    @Autowired
    ReservedService reservedService;

    //@Autowired
    //RestTemplate restTemplate;

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

            //Order newOrder = getOrder(orderRefeId, "Allocated");
            int newAvailableCapacity  = availableCapacity - fuelCapacity;
            byFuelType.setQty(newAvailableCapacity);
            saveAvailableFuel(byFuelType);
            reservedService.getFromAvailable(orderRefeId,fuelType,fuelCapacity);
        }

        return byFuelType;

    }

    /*public Order getOrder(int RefId , String status){
        return 	restTemplate.getForObject("http://order/api/v1/orders/"+RefId+"/"+status, Order.class);
    }*/

}