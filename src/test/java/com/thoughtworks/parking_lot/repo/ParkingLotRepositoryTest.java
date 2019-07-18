package com.thoughtworks.parking_lot.repo;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParkingLotRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Test
    public void should_return_parkingLot_when_call_add_parkingLot(){
        //given
        ParkingLot p1=new ParkingLot("1号停车场",10,"南方软件园");
        //when
        ParkingLot actual=parkingLotRepository.save(p1);
        //then
        Assertions.assertEquals("1号停车场",actual.getName(),"not equal");
    }
}