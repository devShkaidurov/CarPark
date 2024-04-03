package com.pegasAgro.carPark.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegasAgro.carPark.dto.carDTO.CarDTO;
import com.pegasAgro.carPark.dto.carDTO.CreateCarDTO;
import com.pegasAgro.carPark.dto.carDTO.PutCarDTO;
import com.pegasAgro.carPark.services.CarService;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCarById (@PathVariable UUID carId) {
        CarDTO dto = carService.getCarById(carId);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCar (@RequestBody CreateCarDTO carDTO) {
        CarDTO dto = carService.createCar(carDTO);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<?> setCustomerById (@PathVariable UUID carId, @RequestBody PutCarDTO carDTO) {
       CarDTO dto = carService.setCustomerById(carId, carDTO);
       return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteCarById (@PathVariable UUID carId) {
        CarDTO dto = carService.deleteCustomer(carId);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    
}
