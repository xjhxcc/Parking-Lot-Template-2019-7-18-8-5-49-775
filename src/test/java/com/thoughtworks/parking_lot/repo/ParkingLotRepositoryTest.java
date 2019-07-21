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
    @Test
    public void should_return_msg_when_call_delete_parkingLot(){
        //given
        ParkingLot p1=new ParkingLot("1号停车场",10,"唐家市场");
        parkingLotRepository.save(p1);
        parkingLotRepository.save(new ParkingLot("2号停车场",10,"南方软件园"));
        //when
        parkingLotRepository.delete(p1);
        //then
        Assertions.assertEquals(1,parkingLotRepository.findAll().size());
    }
    @Test
    public void should_return_parkingLots_when_call_find_all_parkingLot(){
        //given
        ParkingLot p1=new ParkingLot("1号停车场",10,"唐家市场");
        parkingLotRepository.save(p1);
        parkingLotRepository.save(new ParkingLot("2号停车场",8,"南方软件园"));
        //when
        List<ParkingLot> actual = parkingLotRepository.findAll();
        //then
        Assertions.assertEquals(2,actual.size());
    }
    @Test
    public void should_return_parkingLot_when_call_find_parkingLot_by_id(){
        //given
        ParkingLot p1=new ParkingLot("1号停车场",10,"唐家市场");
        parkingLotRepository.save(p1);
        parkingLotRepository.save(new ParkingLot("2号停车场",8,"南方软件园"));
        //when
        ParkingLot actual = parkingLotRepository.findById(p1.getId()).get();
        //then
        Assertions.assertEquals("唐家市场",actual.getLocation());
    }

}