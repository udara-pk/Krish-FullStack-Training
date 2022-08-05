package com.udara.fuelinventory.fueldistributioninventory.controller;

import com.udara.fuelinventory.fueldistributioninventory.model.Available;
import com.udara.fuelinventory.fueldistributioninventory.service.AvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class AvailableController {

    @Autowired
    AvailableService availableService;


    @PostMapping("/saveavailable")
    public ResponseEntity<Available> saveAvailableFuel(@RequestBody Available available) {
        return availableService.saveAvailableFuel(available);
    }

    @PutMapping("/available/edit/{id}")
    public void updateAvailableFuel(@PathVariable int id,@RequestBody Available available){
        availableService.updateAvailableFuel(available);
    }

    @GetMapping("/available")
    public List<Available> getAvailable(){
        return availableService.getAvailable();
    }


}
