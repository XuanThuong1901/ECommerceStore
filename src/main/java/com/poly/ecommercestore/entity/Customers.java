package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @Column(name = "IDCustomer")
    private String iDCustomer;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "IDCustomer")
    private Accounts account;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    @OneToMany(mappedBy = "customer")
    private List<Carts> carts;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    public Customers() {
    }

    public Customers(String iDCustomer, Accounts account, String name, String address, String telephone) {
        this.iDCustomer = iDCustomer;
        this.account = account;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Customers(String iDCustomer, Accounts account, String name, String address, String telephone, List<Carts> carts, List<Orders> orders) {
        this.iDCustomer = iDCustomer;
        this.account = account;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.carts = carts;
        this.orders = orders;
    }

}
