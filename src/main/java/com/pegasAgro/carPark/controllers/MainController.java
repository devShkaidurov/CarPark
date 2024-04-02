package com.pegasAgro.carPark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pegasAgro.carPark.services.MainService;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;
    
    @PostMapping
    public ResponseEntity<?> createCar (@RequestBody озд car) {

    }

}
