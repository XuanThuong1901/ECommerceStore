package com.poly.ecommercestore.DTO.system;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailImportDTO {
    private int importStock;
    private int product;
    private int quantity;
    private BigDecimal price;

    public DetailImportDTO() {
    }

    public DetailImportDTO(int importStock, int iDProduct, int quantity, BigDecimal price) {
        this.importStock = importStock;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
