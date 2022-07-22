package com.codelabs.rentcloud.customerservice.service;

import com.codelabs.rentcloud.model.customer.Customer;

import java.util.List;


public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
