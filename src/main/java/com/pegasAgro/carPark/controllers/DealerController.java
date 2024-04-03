package com.pegasAgro.carPark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegasAgro.carPark.dto.carDTO.CarWithoutCustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.CustomerDTO;
import com.pegasAgro.carPark.dto.dealerDTO.CreateDealerDTO;
import com.pegasAgro.carPark.dto.dealerDTO.DealerDTO;
import com.pegasAgro.carPark.services.DealerService;

@RestController
@RequestMapping("api/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @GetMapping("/{dealerId}/cars")
    public ResponseEntity<?> getAllCarsByDealerId (@PathVariable long dealerId) {
        List<CarWithoutCustomerDTO> listCars = dealerService.getAllCarsByDealerId(dealerId);
        return new ResponseEntity<>(listCars, listCars == null || listCars.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);    
    }

    @GetMapping("/{dealerId}/customers")
    public ResponseEntity<?> getAllCustomersByDealerId (@PathVariable long dealerId) {
        List<CustomerDTO> listCustomers = dealerService.getAlCustomersByDealerId(dealerId);
        return new ResponseEntity<>(listCustomers, listCustomers == null || listCustomers.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);    
    }

    @PostMapping
    public ResponseEntity<?> createDealer (@RequestBody CreateDealerDTO dealerDto) {
        DealerDTO dto = dealerService.createDealer(dealerDto);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
