package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @JsonIgnore
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
