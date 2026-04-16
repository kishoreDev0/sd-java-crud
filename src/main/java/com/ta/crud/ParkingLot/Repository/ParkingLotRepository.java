package com.ta.crud.ParkingLot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ta.crud.ParkingLot.Entity.ParkingLot;
import java.util.List;


@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer> {

    Optional<ParkingLot> findById(int id);

    Optional<ParkingLot> findByParkingLotName(String parkingLotName);

    List<ParkingLot> findByLocation(String location);

    

}