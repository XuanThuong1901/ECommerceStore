package com.poly.ecommercestore.request.client;

import lombok.Data;

@Data
public class CartRequest {

    private Integer quantity;

    public CartRequest() {
    }

    public CartRequest(Integer quantity) {
        this.quantity = quantity;
    }
}
