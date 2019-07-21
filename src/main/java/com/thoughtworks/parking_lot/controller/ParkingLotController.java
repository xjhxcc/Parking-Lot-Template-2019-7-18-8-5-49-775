package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repo.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/parkingLots")
@RestController
public class ParkingLotController {
    List<ParkingLot> parkingLots=new ArrayList<>();
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotService parkingLotService;
    @PostMapping
    public ParkingLot addPakingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }
    @DeleteMapping
    public void deletePakingLot(@RequestBody ParkingLot parkingLot){
        parkingLotRepository.delete(parkingLot);
    }
    @GetMapping
    public List<ParkingLot> getPakingLots(){
        return parkingLotRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public ParkingLot getPakingLot(@PathVariable Long id){
        return parkingLotRepository.findById(id).get();
    }
    @PutMapping(params = {"id","size"})
    public ResponseEntity updateParkingLotById(@RequestParam("id") Long id, @RequestParam("size") int size ){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(id);
        parkingLot.setSize(size);
        parkingLotService.updateParkingLotById(parkingLot);
        return ResponseEntity.ok().build();
    }
}
