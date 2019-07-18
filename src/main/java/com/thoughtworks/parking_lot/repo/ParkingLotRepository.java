package com.thoughtworks.parking_lot.repo;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
}
