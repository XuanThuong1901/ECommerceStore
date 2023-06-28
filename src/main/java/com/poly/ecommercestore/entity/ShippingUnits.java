package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "ShippingUnits")
public class ShippingUnits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDShippingUnit")
    private int iDShippingUnit;

    @Column(name = "ShippingUnitName")
    private String shippingUnitName;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Telephone", unique = true)
    private String telephone;

    @Column(name = "Address", unique = true)
    private String address;

    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;

    @OneToMany(mappedBy = "shippingUnit")
    private List<Orders> orders;

    public ShippingUnits() {
    }

    public ShippingUnits(String shippingUnitName, String email, String telephone, String address, BigDecimal shippingCost) {
        this.shippingUnitName = shippingUnitName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.shippingCost = shippingCost;
    }

    public ShippingUnits(String shippingUnitName, String email, String telephone, String address, BigDecimal shippingCost, List<Orders> orders) {
        this.shippingUnitName = shippingUnitName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.shippingCost = shippingCost;
        this.orders = orders;
    }
}
