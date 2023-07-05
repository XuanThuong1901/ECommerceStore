package com.poly.ecommercestore.request.system;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailImportRequest {
    private int importStock;
    private int product;
    private int quantity;
    private BigDecimal price;

    public DetailImportRequest() {
    }

    public DetailImportRequest(int importStock, int iDProduct, int quantity, BigDecimal price) {
        this.importStock = importStock;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
