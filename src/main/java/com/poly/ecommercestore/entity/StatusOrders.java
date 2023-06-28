package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "StatusOrders")
public class StatusOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDStatusOrder")
    private int iDStatusOrder;

    @Column(name = "StatusOrderName", unique = true)
    private String StatusOrderName;

    @OneToMany(mappedBy = "statusOrder")
    private List<Orders> orders;

    public StatusOrders() {
    }

    public StatusOrders(String statusOrderName) {
        StatusOrderName = statusOrderName;
    }

    public StatusOrders(String statusOrderName, List<Orders> orders) {
        StatusOrderName = statusOrderName;
        this.orders = orders;
    }
}
