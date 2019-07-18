package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repo.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/parkingLots")
@RestController
public class ParkingLotController {
    List<ParkingLot> parkingLots=new ArrayList<>();
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @PostMapping
    public ParkingLot addPakingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

}
