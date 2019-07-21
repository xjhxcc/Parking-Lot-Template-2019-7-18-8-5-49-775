package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.service.ParkingOrderService;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingOrders")
public class ParkingOrderController {
    @Autowired
    private ParkingOrderService parkingOrderService;
    @PostMapping
    public ParkingOrder addParkingOrder(@RequestBody ParkingOrder parkingOrder){
        return parkingOrderService.addParkingOrder(parkingOrder);
    }
    @PutMapping(params = {"id","end_time"})
    public ResponseEntity updateParkingOrder(@RequestParam("id") Long id , @RequestParam("end_time") String end_time){
        ParkingOrder parkingOrder = new ParkingOrder();
        parkingOrder.setId(id);
        parkingOrder.setEnd_time(end_time);
        parkingOrderService.updateParkingOrder(parkingOrder);
        return ResponseEntity.ok().build();
    }
}
