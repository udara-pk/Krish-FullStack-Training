package com.codelabs.rentcloud.customerservice.repository;

import com.codelabs.rentcloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
