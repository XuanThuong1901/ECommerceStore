package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Evaluations")
public class Evaluations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEvaluation")
    private int iDEvaluation;

    @Column(name = "Contents")
    private String contents;

    @Column(name = "evaluate")
    private int evaluate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iDCustomer")
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iDProduct")
    private Products product;

    public Evaluations() {
    }

    public Evaluations(String contents, int evaluate, Customers customer, Products product) {
        this.contents = contents;
        this.evaluate = evaluate;
        this.customer = customer;
        this.product = product;
    }
}
