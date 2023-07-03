package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.embeddable.DetailOrderId;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "DetailOrders")
public class DetailOrders {

    @EmbeddedId
    private DetailOrderId detailOrderId;

    @Column(name = "Quantity")
    private int quantity;


    @JsonIgnoreProperties("detailOrders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDOrder", referencedColumnName = "IDOrder", insertable = false, updatable = false)
    private Orders order;

    @JsonIgnoreProperties("detailOrders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public DetailOrders() {
    }

    public DetailOrders(DetailOrderId detailOrderId, int quantity, Orders order, Products product) {
        this.detailOrderId = detailOrderId;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }
}
