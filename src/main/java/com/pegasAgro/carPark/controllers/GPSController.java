package com.pegasAgro.carPark.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pegasAgro.carPark.services.GPSService;

@RestController
@RequestMapping("/api/gps")
public class GPSController {
    @Autowired
    private GPSService gpsService;

    @PostMapping
    public ResponseEntity<?> calculateGPS (@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(gpsService.calculateDistance(file) + " meters", HttpStatus.OK);
    }
}
