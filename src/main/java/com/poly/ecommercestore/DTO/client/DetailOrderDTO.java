package com.poly.ecommercestore.DTO.client;

import lombok.Data;

@Data
public class DetailOrderDTO {

    private int product;
    private int quantity;

    public DetailOrderDTO() {
    }

    public DetailOrderDTO(int product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
