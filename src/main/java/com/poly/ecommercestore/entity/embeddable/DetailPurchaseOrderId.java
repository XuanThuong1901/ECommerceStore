package com.poly.ecommercestore.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class DetailPurchaseOrderId implements Serializable {

    @Column(name = "IDPurchaseOrder")
    private int iDPurchaseOrder;

    @Column(name = "IDProduct")
    private int iDProduct;
}
