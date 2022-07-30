package com.udara.fuelapp.fueldistributionapp.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
public class Order {

    private String name;
    private int id;
    private String location;
    private int capacity;
    private String fuelType;
    private String status;

    public  Order(){

    }
    public Order(String name, int id, String location, int capacity, String fuelType, String status) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
