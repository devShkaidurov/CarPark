package com.pegasAgro.carPark.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pegasAgro.carPark.models.Car;
import com.pegasAgro.carPark.models.Customer;
import com.pegasAgro.carPark.models.Dealer;

@Repository
public interface IDealerRepository extends JpaRepository<Dealer, Long> {
    
    @Query("SELECT c FROM Car c " +
            "JOIN Customer cu ON c.customer.id = cu.id " +
            "JOIN Dealer d ON cu.dealer.id = d.id " +
            "WHERE d.id = :id")
    List<Car> findAllCarsById (long id);


    @Query("SELECT c FROM Customer c JOIN Dealer d ON c.dealer.id = d.id WHERE d.id = :id")
    List<Customer> findAllCustomersById (long id);
}
