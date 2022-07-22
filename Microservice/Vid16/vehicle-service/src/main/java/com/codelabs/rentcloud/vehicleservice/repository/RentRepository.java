package com.codelabs.rentcloud.vehicleservice.repository;

import com.codelabs.rentcloud.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
