package com.pegasAgro.carPark.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import lombok.Data;

@Entity
@Table(name = "customers", schema = "public")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @Column
    private String FIO;

    @Column
    private String phoneNumber;

    @Column
    private String mailAddress;

    @OneToMany(mappedBy = "customer", 
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<Car> cars;

    @ManyToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.MERGE)
    @JoinColumn(name = "dealer_id",
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Dealer dealer;
}
