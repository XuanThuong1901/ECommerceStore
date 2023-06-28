package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ExportStocks")
public class ExportStocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDExportStock")
    private int iDExportStock;

    @Column(name = "ExportStockName")
    private String exportStockName;

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

    @OneToMany(mappedBy = "exportStock")
    private List<DetailExportStocks> detailExportStocks;

    public ExportStocks() {
    }

    public ExportStocks(String exportStockName, String contents, Date dateAdded, Employers employer, WareHouses wareHouse) {
        this.exportStockName = exportStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.wareHouse = wareHouse;
    }

    public ExportStocks(String exportStockName, String contents, Date dateAdded, Employers employer, WareHouses wareHouse, List<DetailExportStocks> detailExportStocks) {
        this.exportStockName = exportStockName;
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.employer = employer;
        this.wareHouse = wareHouse;
        this.detailExportStocks = detailExportStocks;
    }
}
