package com.pegasAgro.carPark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegasAgro.carPark.models.Dealer;

@Repository
public interface IDealerRepository extends JpaRepository<Dealer, Long> {
    
}
