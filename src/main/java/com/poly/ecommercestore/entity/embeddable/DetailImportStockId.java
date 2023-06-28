package com.poly.ecommercestore.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class DetailImportStockId implements Serializable {

    @Column(name = "IDImportStock")
    private int iDImportStock;

    @Column(name = "IDProduct")
    private int iDProduct;
}
