package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.embeddable.CartId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "Carts")
public class Carts {

    @EmbeddedId
    private CartId cartId;

    @Column(name = "Quantity")
    private int quantity;

    @JsonIgnoreProperties("carts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDCustomer", referencedColumnName = "IDCustomer", insertable = false, updatable = false)
    private Customers customer;

    @JsonIgnoreProperties("carts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct", insertable = false, updatable = false)
    private Products product;

    public Carts() {
    }

    public Carts(CartId cartId, int quantity, Customers customer, Products product) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
    }
}
