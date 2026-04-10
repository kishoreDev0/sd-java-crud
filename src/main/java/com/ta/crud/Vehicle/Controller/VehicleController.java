package com.ta.crud.Vehicle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Vehicle.Dto.Request.CreateVehicleRequestDto;
import com.ta.crud.Vehicle.Entity.Vehicle;
import com.ta.crud.Vehicle.Service.VehicleService;

import java.util.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Vehicle API", description = "Operations related to vehicles")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping()
    public GenericResponse<List<Vehicle>> getAllVehicle(@RequestParam String param) {

        GenericResponse<List<Vehicle>> vehicleList = vehicleService.getAllvehicle();
        return vehicleList;

    }

    @DeleteMapping
    public GenericResponse<Integer> deleteVehicleById(int id) {

        GenericResponse<Integer> vehicleId = vehicleService.deleteVehicleById(id);
        return vehicleId;

    }

    @GetMapping("/{id}")
    public GenericResponse<Vehicle> getVehicleByName(@RequestParam int id) {

        GenericResponse<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle;

    }

    @GetMapping("/{name}")
    public GenericResponse<Vehicle> getVehicleById(@RequestParam String name) {

        GenericResponse<Vehicle> vehicle = vehicleService.getVehicleByName(name);
        return vehicle;

    }

    @PostMapping()
    public GenericResponse<Vehicle> createVehicleEntire(@RequestBody @Valid CreateVehicleRequestDto vehicle) {

        GenericResponse<Vehicle> Enteredvehicle = vehicleService.createVehicle(vehicle);
        return Enteredvehicle;

    }

    @PutMapping("/{id}")
    public GenericResponse<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {

        GenericResponse<Vehicle> Enteredvehicle = vehicleService.updateVehicleByVehicleNumber(vehicle, id);
        return Enteredvehicle;

    }
}
