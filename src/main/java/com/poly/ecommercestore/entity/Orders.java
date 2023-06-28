package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDOrder")
    private int iDOrder;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Note")
    private String note;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCustomer")
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDShippingUnit")
    private ShippingUnits shippingUnit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDPayment")
    private Payments payment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDStatusOrder")
    private StatusOrders statusOrder;

    @OneToMany(mappedBy = "order")
    private List<DetailOrders> detailOrders;

    public Orders() {
    }

    public Orders(BigDecimal price, String address, String telephone, String note, Customers customer, Employers employer, ShippingUnits shippingUnit, Payments payment, StatusOrders statusOrder) {
        this.price = price;
        this.address = address;
        this.telephone = telephone;
        this.note = note;
        this.customer = customer;
        this.employer = employer;
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.statusOrder = statusOrder;
    }

    public Orders(BigDecimal price, String address, String telephone, String note, Customers customer, Employers employer, ShippingUnits shippingUnit, Payments payment, StatusOrders statusOrder, List<DetailOrders> detailOrders) {
        this.price = price;
        this.address = address;
        this.telephone = telephone;
        this.note = note;
        this.customer = customer;
        this.employer = employer;
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.statusOrder = statusOrder;
        this.detailOrders = detailOrders;
    }
}
