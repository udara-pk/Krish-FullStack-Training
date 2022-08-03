package com.udara.fuelinventory.fueldistributioninventory.controller;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import com.udara.fuelinventory.fueldistributioninventory.service.AvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AvailableController {

    @Autowired
    AvailableService availableService;


    @PostMapping("/saveavailable")
    public ResponseEntity<Available> saveAvailableFuel(@RequestBody Available available) {
        return availableService.saveAvailableFuel(available);
    }


}
