package com.pegasAgro.carPark.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Table(name = "dealers", schema = "public")
@Data
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String agentFIO;

    @OneToMany(mappedBy = "dealer", 
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Customer> customers;
}
