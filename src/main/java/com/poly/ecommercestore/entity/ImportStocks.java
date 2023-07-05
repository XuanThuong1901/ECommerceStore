package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ImportStocks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ImportStocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDImportStock")
    private int iDImportStock;

    @Column(name = "ImportStockName")
    private String importStockName;

    @Column(name = "Contents")
    private String contents;

    @Column(name = "DateAdded")
    private Date dateAdded;

    @JsonIgnoreProperties("importStocks")
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @JsonIgnoreProperties("importStocks")
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSupplier")
    private Suppliers supplier;

    @JsonIgnoreProperties("importStock")
    @OneToMany(mappedBy = "importStock", fetch = FetchType.LAZY)
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
