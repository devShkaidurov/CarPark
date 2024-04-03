package com.pegasAgro.carPark.dto.carDTO;

import java.util.Date;
import java.util.UUID;

import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;

import lombok.Data;

@Data
public class CarDTO {
    private UUID id;
    private Date buildDate;
    private Customer customer;

    public static CarDTO fromEntity (Car car) {
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setCustomer(car.getCustomer());
        dto.setBuildDate(car.getBuildDate());
        return dto;
    } 

    public static Car toEntiy (CarDTO dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setCustomer(dto.getCustomer());
        car.setBuildDate(dto.getBuildDate());
        return car;
    }
}
