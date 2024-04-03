package com.pegasAgro.carPark.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.asm.internal.CharOperation;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.pegasAgro.carPark.dto.carDTO.CarDTO;
import com.pegasAgro.carPark.dto.carDTO.CreateCarDTO;
import com.pegasAgro.carPark.dto.carDTO.PutCarDTO;
import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;
import com.pegasAgro.carPark.repositories.ICarRepository;
import com.pegasAgro.carPark.repositories.ICustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
    private final ICarRepository carRepository;
    private final ICustomerRepository customerRepository;

    public CarDTO getCarById (UUID carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isEmpty())
            return null;
        return CarDTO.fromEntity(car.get());
    }

    public CarDTO createCar (CreateCarDTO dto) {
        Car car = CreateCarDTO.toEntiy(dto);
        Car savedCar = carRepository.save(car);
        return CarDTO.fromEntity(savedCar);
    }

    public CarDTO setCustomerById (UUID carId, PutCarDTO dto) {
        // get car by id
        Optional<Car> carOptional = carRepository.findById(carId);
        if (carOptional.isEmpty())
            return null;
        // get customer by id
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (customerOptional.isEmpty())
            return null;
        Customer customer = customerOptional.get();
        Car car = carOptional.get();
        car.setCustomer(customer);
        Car savedCar = carRepository.save(car);
        if (savedCar == null)
            return null;
        return CarDTO.fromEntity(savedCar);
    }

    public CarDTO deleteCustomer (UUID carId) {
        Optional<Car> carOptional = carRepository.findById(carId);
        if (carOptional.isEmpty())
            return null;
        Car car = carOptional.get();
        car.setCustomer(null);
        Car savedCar = carRepository.save(car);
        return CarDTO.fromEntity(savedCar);
    }
}
