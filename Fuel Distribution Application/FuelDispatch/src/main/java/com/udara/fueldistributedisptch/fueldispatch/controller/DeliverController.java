package com.udara.fueldistributedisptch.fueldispatch.controller;

import com.udara.fueldistributedisptch.fueldispatch.model.Deliver;
import com.udara.fueldistributedisptch.fueldispatch.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DeliverController {

    @Autowired
    DeliverService deliverService;

    @GetMapping("/alldelivers")
    public ResponseEntity<List<Deliver>> getAllDeliver(){

        return deliverService.getAllDeliver();
    }
}
