package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "Payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPayment")
    private int iDPayment;

    @Column(name = "PaymentName", unique = true)
    private String paymentName;

    @Column(name = "Contents")
    private String contents;

    @OneToMany(mappedBy = "payment")
    private List<Orders> orders;

    public Payments() {
    }

    public Payments(String paymentName, String contents) {
        this.paymentName = paymentName;
        this.contents = contents;
    }

    public Payments(String paymentName, String contents, List<Orders> orders) {
        this.paymentName = paymentName;
        this.contents = contents;
        this.orders = orders;
    }
}
