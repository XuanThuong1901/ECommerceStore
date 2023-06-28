package com.poly.ecommercestore.entity;

import com.poly.ecommercestore.entity.embeddable.DetailProductId;
import com.poly.ecommercestore.entity.embeddable.DetailPurchaseOrderId;
import lombok.*;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Carts")
public class DetailProducts {

    @EmbeddedId
    private DetailProductId detailProductId;

    @Column(name = "Quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDWareHouse", referencedColumnName = "IDWareHouse", insertable = false, updatable = false)
    private WareHouses wareHouse;

    public DetailProducts() {
    }

    public DetailProducts(DetailProductId detailProductId, int quantity, Products product, WareHouses wareHouse) {
        this.detailProductId = detailProductId;
        this.quantity = quantity;
        this.product = product;
        this.wareHouse = wareHouse;
    }
}
