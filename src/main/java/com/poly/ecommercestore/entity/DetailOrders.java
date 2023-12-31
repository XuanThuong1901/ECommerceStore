package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.embeddable.DetailOrderId;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DetailOrders")
public class DetailOrders {

    @EmbeddedId
    private DetailOrderId detailOrderId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "LineAmount")
    private BigDecimal lineAmount;

    @JsonIgnore()
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDOrder", referencedColumnName = "IDOrder", insertable = false, updatable = false)
    private Orders order;

    @JsonIgnoreProperties("detailOrders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    @JsonIgnoreProperties("detailOrders")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDTax")
    private Tax tax;

    public DetailOrders() {
    }

    public DetailOrders(DetailOrderId detailOrderId, int quantity, BigDecimal price, BigDecimal lineAmount, Orders order, Products product, Tax tax) {
        this.detailOrderId = detailOrderId;
        this.quantity = quantity;
        this.price = price;
        this.lineAmount = lineAmount;
        this.order = order;
        this.product = product;
        this.tax = tax;
    }
}
