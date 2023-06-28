package com.poly.ecommercestore.entity;

import com.poly.ecommercestore.entity.embeddable.DetailExportStockId;
import lombok.*;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "DetailExportStocks")
public class DetailExportStocks {

    @EmbeddedId
    private DetailExportStockId detailExportStockId;

    @Column(name = "Quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDExportStock", referencedColumnName = "IDExportStock", insertable = false, updatable = false)
    private ExportStocks exportStock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public DetailExportStocks() {
    }

    public DetailExportStocks(DetailExportStockId detailExportStockId, int quantity, ExportStocks exportStock, Products product) {
        this.detailExportStockId = detailExportStockId;
        this.quantity = quantity;
        this.exportStock = exportStock;
        this.product = product;
    }
}
