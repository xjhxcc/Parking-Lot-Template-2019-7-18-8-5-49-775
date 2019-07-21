package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
@Table(name="parking_order")
public class ParkingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String park_name;

    @Column(nullable = false)
    private String car_number;

    @Column(nullable = false)
    private String create_time;

    private String end_time;

    @Column(nullable = false)
    private int status;

    public ParkingOrder() {
    }

    public Long getId() {
        return id;
    }

    public String getPark_name() {
        return park_name;
    }

    public String getCar_number() {
        return car_number;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public int getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ParkingOrder(String park_name, String car_number, String create_time, String end_time, int status) {
        this.park_name = park_name;
        this.car_number = car_number;
        this.create_time = create_time;
        this.end_time = end_time;
        this.status = status;
    }
}
