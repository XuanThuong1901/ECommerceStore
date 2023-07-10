package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTax")
    private int iDTax;

    @Column(name = "Type")
    private String type;

    @Column(name = "TaxPercentage")
    private int taxPercentage;

    @OneToMany(mappedBy = "tax")
    private List<DetailOrders> detailOrders;

    @OneToMany(mappedBy = "tax")
    private List<Products> products;

    public Tax() {
    }

    public Tax(String type, int taxPercentage) {
        this.type = type;
        this.taxPercentage = taxPercentage;
    }
}
