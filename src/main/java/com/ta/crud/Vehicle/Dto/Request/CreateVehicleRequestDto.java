package com.ta.crud.Vehicle.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateVehicleRequestDto {

    @NotBlank(message = "Vehicle name is required")
    public String vehiclename;

    @NotNull(message = "Vehicle number is required")
    public Long vehicleNumber;

}
