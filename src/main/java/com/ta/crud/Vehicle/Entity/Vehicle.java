package com.ta.crud.Vehicle.Entity;

import java.time.LocalDateTime;
import java.time.LocalTime;


import jakarta.persistence.*;

@Entity
public class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long vehicleNumber ;

    private String vehicleName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Contrustor
    public Vehicle(){}

    // Args constructor
    public Vehicle(long id , Long vehicleNumber , String vehicleName ){

        this.id = id;
        this.vehicleName =vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

     public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime localDateTime) {
        this.updatedAt = localDateTime;
    }

}