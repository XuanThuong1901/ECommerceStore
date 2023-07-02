package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduct")
    private int iDProduct;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Feature")
    private String feature;

    @Column(name = "Contents")
    private String contents;

    @Column(name = "Guarantee")
    private String guarantee;

    @Column(name = "Expiry")
    private String expiry;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDetailCategory")
    private DetailCategories detailCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSupplier")
    private Suppliers supplier;

    @OneToMany(mappedBy = "product")
    private List<Specifications> specifications;

    @OneToMany(mappedBy = "product")
    private List<ImageProducts> imageProducts;

    @OneToMany(mappedBy = "product")
    private List<DetailImportStocks> detailImportStocks;

    @OneToMany(mappedBy = "product")
    private List<Carts> carts;

    @OneToMany(mappedBy = "product")
    private List<DetailOrders> detailOrders;

    public Products() {
    }

    public Products(String productName, int quantity, BigDecimal price, String feature, String contents, String guarantee, String expiry, DetailCategories detailCategory, Suppliers supplier) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.feature = feature;
        this.contents = contents;
        this.guarantee = guarantee;
        this.expiry = expiry;
        this.detailCategory = detailCategory;
        this.supplier = supplier;
    }

    public Products(String productName, int quantity, BigDecimal price, String feature, String contents, String guarantee, String expiry, DetailCategories detailCategory, Suppliers supplier, List<Specifications> specifications, List<ImageProducts> imageProducts, List<DetailImportStocks> detailImportStocks, List<Carts> carts, List<DetailOrders> detailOrders) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.feature = feature;
        this.contents = contents;
        this.guarantee = guarantee;
        this.expiry = expiry;
        this.detailCategory = detailCategory;
        this.supplier = supplier;
        this.specifications = specifications;
        this.imageProducts = imageProducts;
        this.detailImportStocks = detailImportStocks;
        this.carts = carts;
        this.detailOrders = detailOrders;
    }
}
