package com.pegasAgro.carPark.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c.cars FROM Customer c WHERE c.id = :id")
    List<Car> findAllCarsById(long id);
    
}
