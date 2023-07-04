package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.embeddable.DetailImportStockId;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DetailImportStocks")
public class DetailImportStocks {

    @EmbeddedId
    private DetailImportStockId detailImportStockId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @JsonIgnoreProperties("detailImportStocks")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDImportStock", referencedColumnName = "IDImportStock", insertable = false, updatable = false)
    private ImportStocks importStock;

    @JsonIgnoreProperties("detailImportStocks")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public DetailImportStocks() {
    }

    public DetailImportStocks(int quantity, BigDecimal price, ImportStocks importStock, Products product) {
//        this.detailImportStockId = detailImportStockId;
        this.quantity = quantity;
        this.price = price;
        this.importStock = importStock;
        this.product = product;
    }
}
