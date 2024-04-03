package com.pegasAgro.carPark.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class GPSService {
    private static final double EARTH_RADIUS = 6371000;

    public double calculateDistance (MultipartFile file) throws IOException {
        InputStreamReader stream = new InputStreamReader(file.getInputStream());
        BufferedReader reader = new BufferedReader(stream);

        boolean isGGA = true; 
        double seconds = 60d;
        String line = "";
        double prevLat = -1d;
        double prevLon = -1d;

        double latitude = 0d;
        double longitude = 0d;
        double distance = 0d; // resulting variable

        while((line = reader.readLine()) != null) {
            if (isGGA) {
                while(line != null && !line.contains("GPGGA")) {
                    line = reader.readLine();
                }

                if (line == null) {
                    continue;
                }

                String[] parts = line.split(",");
                String lat = parts[2];
                String lon = parts[4];

                if (parts.length < 8 || lat.length() < 3 || lon.length() < 3)
                    continue;
                if (prevLat == -1d || prevLon == -1d) {
                    latitude = Double.parseDouble(lat.substring(0, 2)) + Double.parseDouble(lat.substring(2, lat.length() - 1)) / seconds;
                    prevLat = Double.parseDouble(lat.substring(0, 2)) + Double.parseDouble(lat.substring(2, lat.length() - 1)) / seconds;
                    longitude = Double.parseDouble(lon.substring(1, 3)) + Double.parseDouble(lon.substring(3, lon.length() - 1)) / seconds;
                    prevLon = Double.parseDouble(lon.substring(1, 3)) + Double.parseDouble(lon.substring(3, lon.length() - 1)) / seconds;
                } else {
                    latitude = Double.parseDouble(lat.substring(0, 2)) + Double.parseDouble(lat.substring(2, lat.length() - 1)) / seconds;
                    longitude = Double.parseDouble(lon.substring(1, 3)) + Double.parseDouble(lon.substring(3, lon.length() - 1)) / seconds;
                }
                isGGA = !isGGA;
            } else {
                while(line != null && !line.contains("GNVTG")) {
                    line = reader.readLine();
                }

                if (line == null) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 5)
                    continue;
                String vel = parts[5];
                double velocity = Double.parseDouble(vel);

                // расстояние не учитывается, если скорость равна нулю
                if (velocity == 0d) {
                    latitude = 0;
                    longitude = 0;
                }

                // calculate
                distance += calculateDistance(prevLat, prevLon, latitude, longitude);
                System.out.println(distance);
                // set prev as actual values
                prevLat = latitude;
                prevLon = longitude;

                isGGA = !isGGA;
            }
        }
        return distance;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }
    
  
   
   
}
