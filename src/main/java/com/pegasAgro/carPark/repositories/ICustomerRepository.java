package com.pegasAgro.carPark.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegasAgro.carPark.models.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    
}
