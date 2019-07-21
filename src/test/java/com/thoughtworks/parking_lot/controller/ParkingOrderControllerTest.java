package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.service.ParkingOrderService;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ParkingOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParkingOrderService parkingOrderService;
    @Test
    public void should_return_parking_order_when_add() throws Exception {
        ResultActions mvcResult = mockMvc.perform(post("/parkingOrders").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"park_name\": \"parkinglot\",\n" +
                        "  \"car_number\": \"湘F41520\",\n" +
                        "  \"create_time\": \"2019-07-19\",\n" +
                        "  \"end_time\": \"2019-07-20\",\n" +
                        "  \"status\": 1\n" +
                        "}")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.create_time").value("2019-07-19"));
    }
    @Test
    public void should_update_parking_order_end_time() throws Exception {
        //given
        parkingOrderService.addParkingOrder(new ParkingOrder("parkinglot1", "湘F51420", "2019-07-19", "2019-07-21", 1));
        MvcResult mvcResult = this.mockMvc.perform(put("/parkingOrders?id=1&end_time=2019-07-21"))
                .andExpect(status().isOk()).andReturn();
        //when
        ParkingOrder newParkingOrder = parkingOrderService.findParkingOrderById((long)1);
        //then
        Assertions.assertEquals("2019-07-21", newParkingOrder.getEnd_time());
    }

}