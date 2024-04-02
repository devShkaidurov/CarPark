package com.pegasAgro.carPark.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegasAgro.carPark.models.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, UUID> {
    
}
