package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Setter
@Entity
@Table(name = "Suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSupplier")
    private int iDSupplier;

    @Column(name = "SupplierName")
    private String supplierName;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Telephone", unique = true)
    private String telephone;

    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<ImportStocks> importStocks;

    @OneToMany(mappedBy = "supplier")
    private List<Products> products;

    public Suppliers() {
    }

    public Suppliers(String supplierName, String email, String telephone, String address) {
        this.supplierName = supplierName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public Suppliers(String supplierName, String email, String telephone, String address, List<ImportStocks> importStocks, List<Products> products) {
        this.supplierName = supplierName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.importStocks = importStocks;
        this.products = products;
    }
}
