package com.thoughtworks.parking_lot.repo;

import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrder,Long> {
    @Query(value = "update parking_order set end_time = :#{#parkingOrder.end_time},status = 0 where id = :#{#parkingOrder.id}",nativeQuery = true)
    @Modifying
    void updateParkingOrder(@Param("parkingOrder") ParkingOrder parkingOrder);
}
