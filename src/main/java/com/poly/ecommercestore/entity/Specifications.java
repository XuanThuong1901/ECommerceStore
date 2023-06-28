package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Specifications")
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSpecification")
    private int iDSpecification;

    @Column(name = "SpecificationName", unique = true)
    private String specificationName;

    @Column(name = "Parameter")
    private String parameter;

    @ManyToOne
    @JoinColumn(name = "IDProduct")
    private Products product;

    public Specifications() {
    }

    public Specifications(String specificationName, String parameter) {
        this.specificationName = specificationName;
        this.parameter = parameter;
    }

    public Specifications(String specificationName, String parameter, Products product) {
        this.specificationName = specificationName;
        this.parameter = parameter;
        this.product = product;
    }
}
