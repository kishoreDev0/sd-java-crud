package com.ta.crud.Vehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.ta.crud.Vehicle.Entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle , Long> {

    List<Vehicle> getAllVehicle();

    Optional<Vehicle> findById(Long id);

    Optional<Vehicle> findByName(String name);

    int deleteById(int id);

    Optional<Vehicle> findByVehicleNumber(Long vehicleNumber);

    
} 
