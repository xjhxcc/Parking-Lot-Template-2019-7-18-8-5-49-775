package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.model.ParkingOrder;
import com.thoughtworks.parking_lot.repo.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ParkingOrderService {
    @Autowired
    private ParkingOrderRepository parkingOrderResponsitory;

    public ParkingOrder addParkingOrder(ParkingOrder parkingOrder){
        return parkingOrderResponsitory.save(parkingOrder);
    }
    public void updateParkingOrder(ParkingOrder parkingOrder){
        parkingOrderResponsitory.updateParkingOrder(parkingOrder);
    }

    public ParkingOrder findParkingOrderById(Long id) {
        return parkingOrderResponsitory.findById(id).get();
    }
}
