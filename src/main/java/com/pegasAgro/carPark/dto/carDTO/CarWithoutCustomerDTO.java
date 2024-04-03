package com.pegasAgro.carPark.dto.carDTO;

import java.util.Date;
import java.util.UUID;

import com.pegasAgro.carPark.models.Car;

import lombok.Data;

@Data
public class CarWithoutCustomerDTO {
    private UUID id;
    private Date buildDate;

    public static CarWithoutCustomerDTO fromEntity (Car car) {
        CarWithoutCustomerDTO dto = new CarWithoutCustomerDTO();
        dto.setId(car.getId());
        dto.setBuildDate(car.getBuildDate());
        return dto;
    } 

    public static Car toEntiy (CarWithoutCustomerDTO dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setBuildDate(dto.getBuildDate());
        return car;
    }
}