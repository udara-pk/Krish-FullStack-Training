package com.udara.fueldisribschedule.fuelschedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "Schedule")
public class Schedule {
    @Id
    private int orderRefId;
    private String fuelType;
    private int qty;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;
    private String status;

    public Schedule(){

    }

    public Schedule(int orderRefId, String fuelType, int qty, LocalDate scheduleDate, String status) {
        this.orderRefId = orderRefId;
        this.fuelType = fuelType;
        this.qty = qty;
        this.scheduleDate = scheduleDate;
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

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}