package com.codelabs.rentcloud.customerservice.controller;

import com.codelabs.rentcloud.customerservice.service.CustomerService;
import com.codelabs.rentcloud.model.customer.Customer;
import com.springframework.beans.factory.annotation.Autowired;
import com.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/services/customers")
public class CustomerServiceController {


    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable int id) {

        System.out.println("request came on "+LocalDateTime.now() + "  ++++++++++++++++++++++");
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }




}
