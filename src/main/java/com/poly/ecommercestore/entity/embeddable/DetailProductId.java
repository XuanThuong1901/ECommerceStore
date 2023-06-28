package com.poly.ecommercestore.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class DetailProductId implements Serializable {

    @Column(name = "IDProduct")
    private int iDProduct;

    @Column(name = "IDWareHouse")
    private int iDWareHouse;
}
