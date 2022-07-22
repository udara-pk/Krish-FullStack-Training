package com.codelabs.rentcloud.rentservice.service;

import com.codelabs.rentcloud.model.rent.Rent;
import com.codelabs.rentcloud.rentservice.model.DetailResponse;
import com.codelabs.rentcloud.rentservice.model.Response;

import java.util.List;


public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id);
}
