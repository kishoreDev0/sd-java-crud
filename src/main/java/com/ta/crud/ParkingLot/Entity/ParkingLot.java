package com.ta.crud.ParkingLot.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String parkingLotName;
    private String location ;

    private int totalSlot;

    private boolean availablity;


    public ParkingLot(String parkingLotName , String location ,int totalSlot,boolean availablity){
        this.parkingLotName = parkingLotName;
        this.location = location;
        this.totalSlot =totalSlot;
        this.availablity = availablity;
    }

    public ParkingLot(){}

}
