package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Note")
    private String note;

    @Column(name = "ShippingFee")
    private BigDecimal shippingFee;

    @Column(name = "TaxAmount ")
    private BigDecimal taxAmount  ;

    @Column(name = "DiscountAmount")
    private BigDecimal discountAmount ;

    @JsonIgnoreProperties("orders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDCustomer")
    private Customers customer;

    @JsonIgnoreProperties("orders")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @JsonIgnoreProperties("orders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDShippingUnit")
    private ShippingUnits shippingUnit;

    @JsonIgnoreProperties("orders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDPayment")
    private Payments payment;

    @JsonIgnoreProperties("orders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDStatus")
    private Status status;

    @JsonIgnoreProperties("order")
    @OneToMany(mappedBy = "order")
    private List<DetailOrders> detailOrders;

    public Orders() {
    }

    public Orders(BigDecimal amount, String address, String telephone, String note, Customers customer, Employers employer, ShippingUnits shippingUnit, Payments payment, Status status) {
        this.amount = amount;
        this.address = address;
        this.telephone = telephone;
        this.note = note;
        this.customer = customer;
        this.employer = employer;
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.status = status;
    }

    public Orders(BigDecimal amount, String address, String telephone, String note, Customers customer, Employers employer, ShippingUnits shippingUnit, Payments payment, Status status, List<DetailOrders> detailOrders) {
        this.amount = amount;
        this.address = address;
        this.telephone = telephone;
        this.note = note;
        this.customer = customer;
        this.employer = employer;
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.status = status;
        this.detailOrders = detailOrders;
    }
}
