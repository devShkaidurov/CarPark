package com.pegasAgro.carPark.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pegasAgro.carPark.nmea.NmeaParser;

@Service
public class GPSService {
    public double calculateDistance (MultipartFile file) throws IOException {
        try {
            return NmeaParser.calculateDistance(file.getInputStream());
        } catch (IOException e) {
            return -1d;
        }
    }
    
  
   
   
}
