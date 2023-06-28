package com.poly.ecommercestore.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class DetailOrderId implements Serializable {

    @Column(name = "IDOrder")
    private int iDOrder;

    @Column(name = "IDProduct")
    private int iDProduct;
}
