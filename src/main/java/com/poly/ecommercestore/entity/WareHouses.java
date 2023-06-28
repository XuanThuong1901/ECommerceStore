package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "WareHouses")
public class WareHouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDWareHouse")
    private int iDWareHouse;

    @Column(name = "WareHouseName")
    private String wareHouseName;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Telephone", unique = true)
    private String telephone;

    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "wareHouse")
    private List<ExportStocks> exportStocks;

    @OneToMany(mappedBy = "wareHouse")
    private List<ImportStocks> importStocks;

    @OneToMany(mappedBy = "wareHouse")
    private List<DetailProducts> detailProducts;

    public WareHouses() {
    }

    public WareHouses(String wareHouseName, String email, String telephone, String address) {
        this.wareHouseName = wareHouseName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public WareHouses(String wareHouseName, String email, String telephone, String address, List<ExportStocks> exportStocks, List<ImportStocks> importStocks, List<DetailProducts> detailProducts) {
        this.wareHouseName = wareHouseName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.exportStocks = exportStocks;
        this.importStocks = importStocks;
        this.detailProducts = detailProducts;
    }
}
