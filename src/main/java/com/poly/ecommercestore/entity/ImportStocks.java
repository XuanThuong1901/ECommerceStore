package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ImportStocks")
public class ImportStocks {

    @Id
    @Column(name = "IDImportStock")
    private int iDImportStock;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDImportStock")
    private PurchaseOrders purchaseOrder;

    @Column(name = "ImportStockName")
    private String importStockName;

    @Column(name = "Contents")
    private String contents;

    @Column(name = "DateAdded")
    private Date dateAdded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDWareHouse")
    private WareHouses wareHouse;

    @OneToMany(mappedBy = "importStock")
    private List<DetailImportStocks> detailImportStocks;

    public ImportStocks() {
    }

    public ImportStocks(PurchaseOrders purchaseOrder, String importStockName, String contents, Date dateAdded, Employers employer, WareHouses wareHouse) {
        this.purchaseOrder = purchaseOrder;
        this.importStockName = importStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.wareHouse = wareHouse;
    }

    public ImportStocks(PurchaseOrders purchaseOrder, String importStockName, String contents, Date dateAdded, Employers employer, WareHouses wareHouse, List<DetailImportStocks> detailImportStocks) {
        this.purchaseOrder = purchaseOrder;
        this.importStockName = importStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.wareHouse = wareHouse;
        this.detailImportStocks = detailImportStocks;
    }
}
