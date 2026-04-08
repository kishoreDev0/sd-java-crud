package com.ta.crud.Vehicle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.ta.crud.Generic.GenericResponse;
import com.ta.crud.Generic.GenericResponseBuilder;
import com.ta.crud.Vehicle.Entity.Vehicle;
import com.ta.crud.Vehicle.Repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository VehicleRepository;

    private GenericResponseBuilder genericResponseBuilder;

    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);

    public GenericResponse<Vehicle> createVehicle(Vehicle vehicle) {

        Optional<Vehicle> existingVehicle = VehicleRepository.findByVehicleNumber(vehicle.getVehicleNumber());

        if (existingVehicle.isEmpty()) {
            log.warn("No items found");
            return genericResponseBuilder.info(200,
                    "Vehicle with " + vehicle.getVehicleNumber() + " number is already entered");
        }

        // Saving the vehicle
        Vehicle vehicleCreated = VehicleRepository.save(vehicle);

        return genericResponseBuilder.success(204,
                true,
                vehicleCreated,
                "Vehicles Entered succesfully");

    }

    public GenericResponse<Vehicle> updateVehicleByVehicleNumber(Vehicle vehicle) {

        Optional<Vehicle> existingVehicle = VehicleRepository.findByVehicleNumber(vehicle.getVehicleNumber());

        if (existingVehicle.isEmpty()) {
            log.warn("No items found");
            return genericResponseBuilder.info(200,
                    "Vehicle with " + vehicle.getVehicleNumber() + " number is already entered");
        }

        // Updating the vehicle details
        existingVehicle.get().setVehicleName(vehicle.getVehicleName());
        existingVehicle.get().setVehicleNumber(vehicle.getVehicleNumber());

        Vehicle vehicleUpdated = VehicleRepository.save(existingVehicle.get());

        return genericResponseBuilder.success(204,
                true,
                vehicleUpdated,
                "Vehicles Updated succesfully");

    }

    public GenericResponse<List<Vehicle>> getAllvehicle() {
        try {
            List<Vehicle> vehicleList = VehicleRepository.getAllVehicle();
            log.debug("Number of items present" + vehicleList.size());
            if (vehicleList.isEmpty()) {
                log.warn("No items found");
                return genericResponseBuilder.error(200, "No items found");

            }
            return genericResponseBuilder.success(204,
                    true,
                    vehicleList,
                    "Vehicles fecthed");

        } catch (Exception exception) {
            log.error("Vehical service has been failed" + exception);
            return genericResponseBuilder.error(200, exception.getMessage());
        }

    }

    public GenericResponse<Vehicle> getVehicleById(Long id) {
        try {
            Optional<Vehicle> vehicle = VehicleRepository.findById(id);
            if (vehicle.isEmpty()) {
                log.info("No vehical with the id " + id + " found");
                return genericResponseBuilder.error(200, "No items found");
            }
            log.info("Vehicle with id " + id + " has been found");
            return genericResponseBuilder.success(204,
                    true,
                    vehicle.get(),
                    "Vehicle with id " + id + " has been fetched");

        } catch (Exception e) {
            log.error("No vehical with the id " + id + " found" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<Vehicle> getVehicleByName(String name) {
        try {
            Optional<Vehicle> vehicle = VehicleRepository.findByName(name);
            if (vehicle.isEmpty()) {
                log.info("No vehical with the name " + name + " found");
                return genericResponseBuilder.error(200, "No items found");
            }
            log.info("Vehicle with id " + name + " has been found");
            return genericResponseBuilder.success(204,
                    true,
                    vehicle.get(),
                    "Vehicle with name " + name + " has been fetched");

        } catch (Exception e) {
            log.error("No vehical with the id " + name + " found" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<Long> deleteVehicleById(Long id) {
        try {

            Optional<Vehicle> vehicle = VehicleRepository.findById(id);

            if (vehicle.isEmpty()) {
                log.info("No vehical with the id " + id + " found");
                return genericResponseBuilder.error(200, "Vehicle with id " + id + " not found");
            }
            log.info("Vehicle with id " + id + " has been deleted");
            return genericResponseBuilder.success(204,
                    true,
                    vehicle.get().getId(),
                    "Vehicle with id " + id + " has been deleted");
        } catch (Exception e) {
            log.error("No vehical with the id " + id + " found ," + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

}
