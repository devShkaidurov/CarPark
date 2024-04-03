package com.pegasAgro.carPark.dto.carDTO;

import java.util.Date;

import com.pegasAgro.carPark.models.Car;

import lombok.Data;

@Data
public class CreateCarDTO {
    private Date buildDate;

    public static CreateCarDTO fromEntity (Car car) {
        CreateCarDTO dto = new CreateCarDTO();
        dto.setBuildDate(car.getBuildDate());
        return dto;
    } 

    public static Car toEntiy (CreateCarDTO dto) {
        Car car = new Car();
        car.setBuildDate(dto.getBuildDate());
        return car;
    }
}
