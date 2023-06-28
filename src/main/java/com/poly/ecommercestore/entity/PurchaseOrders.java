package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "PurchaseOrders")
public class PurchaseOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPurchaseOrder")
    private int iDPurchaseOrders;

    @Column(name = "PurchaseOrderName")
    private String purchaseOrdersName;

    @Column(name = "DateAdded")
    private Date dateAdded;

    @Column(name = "Contents")
    private String contents;

    @OneToOne(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ImportStocks importStock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSupplier")
    private Suppliers supplier;

    public PurchaseOrders() {
    }

    public PurchaseOrders(String purchaseOrdersName, Date dateAdded, String contents, ImportStocks importStock, Employers employer, Suppliers supplier) {
        this.purchaseOrdersName = purchaseOrdersName;
        this.dateAdded = dateAdded;
        this.contents = contents;
        this.importStock = importStock;
        this.employer = employer;
        this.supplier = supplier;
    }
}
