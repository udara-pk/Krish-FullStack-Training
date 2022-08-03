package com.udara.fuelinventory.fueldistributioninventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reserved")
public class Reserved {

    @Id
    private int orderRefId;
    private String fuelType;
    private int qty;

    public Reserved() {

    }

    public Reserved(int orderRefId, String fuelType, int qty) {
        super();
        this.orderRefId = orderRefId;
        this.fuelType = fuelType;
        this.qty = qty;
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

}
