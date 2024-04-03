package com.pegasAgro.carPark.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pegasAgro.carPark.dto.carDTO.CarDTO;
import com.pegasAgro.carPark.dto.customerDTO.CreateCustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.CustomerDTO;
import com.pegasAgro.carPark.dto.customerDTO.PutCustomerDTO;
import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;
import com.pegasAgro.carPark.models.Dealer;
import com.pegasAgro.carPark.repositories.ICustomerRepository;
import com.pegasAgro.carPark.repositories.IDealerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final ICustomerRepository customerRepository;
    private final IDealerRepository dealerRepository;

    public List<CarDTO> getCarsByCustomerId (long customerId) {
        List<Car> cars = customerRepository.findAllCarsById(customerId);
        return cars.stream()
            .map(CarDTO::fromEntity)
            .toList();
    }

    public CustomerDTO createCustomer (CreateCustomerDTO dto) {
        Customer createdEntity = customerRepository.save(CreateCustomerDTO.toEntiy(dto));
        return CustomerDTO.fromEntity(createdEntity);
    }

    public CustomerDTO setDealer (long customerId, PutCustomerDTO dto) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty())
            return null;
        Optional<Dealer> dealerOptional = dealerRepository.findById(dto.getDealerId());
        if (dealerOptional.isEmpty())
            return null;
        Customer customer = customerOptional.get();
        customer.setDealer(dealerOptional.get());
        Customer savedCustomer = customerRepository.save(customer);
        if (savedCustomer == null)
            return null;
        return CustomerDTO.fromEntity(savedCustomer);
    }

    public CustomerDTO deleteCustomerById (long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty())
            return null;
        Customer customer = customerOptional.get();
        customer.setDealer(null);
        Customer savedCustomer = customerRepository.save(customer);
        if (savedCustomer == null)
            return null;
        return CustomerDTO.fromEntity(savedCustomer);
    }
}
