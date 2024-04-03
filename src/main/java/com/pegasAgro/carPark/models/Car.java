package com.pegasAgro.carPark.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cars", schema = "public")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;
    
    @Column
    private Date buildDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id",
        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonManagedReference
    private Customer customer;

}
