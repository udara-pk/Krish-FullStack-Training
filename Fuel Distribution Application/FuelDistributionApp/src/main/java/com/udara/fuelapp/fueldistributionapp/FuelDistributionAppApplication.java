package com.udara.fuelapp.fueldistributionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FuelDistributionAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelDistributionAppApplication.class, args);
    }

}
