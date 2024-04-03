package com.pegasAgro.carPark.controllers;

import java.util.List;

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
import com.pegasAgro.carPark.dto.customerDTO.CreateCustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.CustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.PutCustomerDTO;
import com.pegasAgro.carPark.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/{customerId}/cars")
    public ResponseEntity<?> getCarsByCustomerId (@PathVariable long customerId) {
        List<CarDTO> dto = customerService.getCarsByCustomerId(customerId);
        return new ResponseEntity<>(dto, dto == null || dto.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer (@RequestBody CreateCustomerDTO customerDto) {
        CustomerDTO dto = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> setDealer (@PathVariable long customerId, @RequestBody PutCustomerDTO customerDTO) {
        CustomerDTO dto = customerService.setDealer(customerId, customerDTO);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

   
    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteCustomer (@PathVariable long customerId) {
        CustomerDTO dto = customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
