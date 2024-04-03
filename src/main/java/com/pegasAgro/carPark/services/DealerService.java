package com.pegasAgro.carPark.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pegasAgro.carPark.dto.carDTO.CarWithoutCustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.CustomerDTO;
import com.pegasAgro.carPark.dto.dealerDTO.CreateDealerDTO;
import com.pegasAgro.carPark.dto.dealerDTO.DealerDTO;
import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;
import com.pegasAgro.carPark.models.Dealer;
import com.pegasAgro.carPark.repositories.IDealerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DealerService {
    private final IDealerRepository dealerRepository;

    public List<CarWithoutCustomerDTO> getAllCarsByDealerId (long dealerId) {
        List<Car> listCars = dealerRepository.findAllCarsById(dealerId);
        return listCars.stream()
            .map(CarWithoutCustomerDTO::fromEntity)
            .toList();
    }

    public List<CustomerDTO> getAlCustomersByDealerId (long dealerId) {
        List<Customer> listCustomers = dealerRepository.findAllCustomersById(dealerId);
        return listCustomers.stream()
            .map(CustomerDTO::fromEntity)
            .toList();
    }

    public DealerDTO createDealer (CreateDealerDTO dto) {
        Dealer dealer = dealerRepository.save(CreateDealerDTO.toEntity(dto));
        if (dealer == null)
            return null;
        return DealerDTO.fromEntity(dealer);
    }
}
