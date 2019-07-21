package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repo.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    public void updateParkingLotById(ParkingLot parkingLot){
        parkingLotRepository.updateById(parkingLot);
    }

}
