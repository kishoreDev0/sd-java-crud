package com.ta.crud.Vehicle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.ta.crud.Generic.GenericResponse;
import com.ta.crud.Vehicle.Entity.Vehicle;
import com.ta.crud.Vehicle.Service.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;

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
    public GenericResponse<Long> deleteVehicleById(long id) {

        GenericResponse<Long> vehicleId = vehicleService.deleteVehicleById(id);
        return vehicleId;

    }

    @GetMapping("/{id}")
    public GenericResponse<Vehicle> getVehicleByName(@RequestParam Long id) {

        GenericResponse<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle;

    }

    @GetMapping("/{name}")
    public GenericResponse<Vehicle> getVehicleById(@RequestParam String name) {

        GenericResponse<Vehicle> vehicle = vehicleService.getVehicleByName(name);
        return vehicle;

    }

}
