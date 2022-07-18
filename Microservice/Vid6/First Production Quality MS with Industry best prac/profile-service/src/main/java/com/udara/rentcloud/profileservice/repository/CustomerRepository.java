package com.udara.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udara.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
