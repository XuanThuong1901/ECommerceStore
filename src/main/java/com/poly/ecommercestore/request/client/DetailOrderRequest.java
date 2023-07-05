package com.poly.ecommercestore.request.client;

import lombok.Data;

@Data
public class DetailOrderRequest {

    private int product;
    private int quantity;

    public DetailOrderRequest() {
    }

    public DetailOrderRequest(int product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
