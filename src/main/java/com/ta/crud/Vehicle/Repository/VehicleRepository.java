package com.ta.crud.Vehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ta.crud.Vehicle.Entity.Vehicle;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle , Integer> {


    Optional<Vehicle> findById(int id);

    Optional<Vehicle> findByVehicleName(String name);

    int deleteById(int id);

    Optional<Vehicle> findByVehicleNumber(int vehicleNumber);

    
} 
