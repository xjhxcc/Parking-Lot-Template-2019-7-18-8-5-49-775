package com.thoughtworks.parking_lot.repo;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
    @Query(value = "update parking_lot set parking_size = :#{#parkingLot.size} where id = :#{#parkingLot.id}",nativeQuery = true)
    @Modifying
    void updateById(@Param("parkingLot") ParkingLot parkingLot);
}
