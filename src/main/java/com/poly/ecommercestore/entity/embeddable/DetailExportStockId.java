package com.poly.ecommercestore.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class DetailExportStockId implements Serializable {

    @Column(name = "IDExportStock")
    private int iDExportStock;

    @Column(name = "IDProduct")
    private int iDProduct;
}
