package com.poly.ecommercestore.entity;

import com.poly.ecommercestore.entity.embeddable.DetailExportStockId;
import com.poly.ecommercestore.entity.embeddable.DetailPurchaseOrderId;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "DetailPurchaseOrders")
public class DetailPurchaseOrders {

    @EmbeddedId
    private DetailPurchaseOrderId detailPurchaseOrderId;

    @Column(name = "Quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDPurchaseOrder", referencedColumnName = "IDPurchaseOrder", insertable = false, updatable = false)
    private PurchaseOrders purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public DetailPurchaseOrders() {
    }

    public DetailPurchaseOrders(DetailPurchaseOrderId detailPurchaseOrderId, int quantity, PurchaseOrders purchaseOrder, Products product) {
        this.detailPurchaseOrderId = detailPurchaseOrderId;
        this.quantity = quantity;
        this.purchaseOrder = purchaseOrder;
        this.product = product;
    }
}
