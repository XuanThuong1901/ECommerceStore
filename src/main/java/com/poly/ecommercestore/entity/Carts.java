package com.poly.ecommercestore.entity;

import com.poly.ecommercestore.entity.embeddable.CartId;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Carts")
public class Carts {

    @EmbeddedId
    private CartId cartId;

    @Column(name = "CategoryName")
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCustomer", referencedColumnName = "IDCustomer", insertable = false, updatable = false)
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public Carts() {
    }

    public Carts(String categoryName, Customers customer, Products product) {
        this.categoryName = categoryName;
        this.customer = customer;
        this.product = product;
    }
}
