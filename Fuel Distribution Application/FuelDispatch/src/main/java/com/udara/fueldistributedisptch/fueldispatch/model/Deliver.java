package com.udara.fueldistributedisptch.fueldispatch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Deliver")
public class Deliver {
    @Id
    private int orderRefId;
    private String fuelType;
    private int qty;
    //@JsonFormat(pattern = "yyyy-MM-dd")

    private String status;

    public Deliver(){

    }

    public Deliver(int orderRefId, String fuelType, int qty, String status) {
        this.orderRefId = orderRefId;
        this.fuelType = fuelType;
        this.qty = qty;
        this.status = status;
    }

    public int getOrderRefId() {
        return orderRefId;
    }

    public void setOrderRefId(int orderRefId) {
        this.orderRefId = orderRefId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
