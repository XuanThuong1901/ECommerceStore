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
    @JoinColumn(name = "IDSupplier")
    private Suppliers supplier;

    @OneToMany(mappedBy = "importStock")
    private List<DetailImportStocks> detailImportStocks;

    public ImportStocks() {
    }

    public ImportStocks(int iDImportStock, String importStockName, String contents, Date dateAdded, Employers employer, Suppliers supplier) {
        this.iDImportStock = iDImportStock;
        this.importStockName = importStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.supplier = supplier;
    }

    public ImportStocks(int iDImportStock, String importStockName, String contents, Date dateAdded, Employers employer, List<DetailImportStocks> detailImportStocks) {
        this.iDImportStock = iDImportStock;
        this.importStockName = importStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.detailImportStocks = detailImportStocks;
    }
}
