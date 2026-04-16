package com.ta.crud.ParkingLot.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ta.crud.ParkingLot.Entity.ParkingLot;
import com.ta.crud.ParkingLot.Repository.ParkingLotRepository;
import com.ta.crud.User.Service.UserService;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;

@Service
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private GenericResponseBuilder genericResponseBuilder;
    private static final Logger log = LoggerFactory.getLogger(ParkingLotService.class);

    public ParkingLotService() {
    }

    public ParkingLotService(ParkingLotRepository parkingLotRepository, GenericResponseBuilder genericResponseBuilder) {
        this.parkingLotRepository = parkingLotRepository;
        this.genericResponseBuilder = genericResponseBuilder;
    }

    public GenericResponse<ParkingLot> getParkingLotById(int id) {

        try {
            Optional<ParkingLot> fetchedParkingLot = parkingLotRepository.findById(id);
            log.info("Feteching started with the id " + id + " provided");

            if (!fetchedParkingLot.isPresent()) {
                log.error("Feteching started with the id " + id + " provided");
                return genericResponseBuilder.info(200, "Feteching started with the id " + id + " provided");
            }

            return genericResponseBuilder.success(id, true, fetchedParkingLot.get(), "");

        } catch (Exception e) {
            return genericResponseBuilder.error(id, "Error find data " + e.getMessage());
        }
    }

}
