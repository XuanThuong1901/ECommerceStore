package com.poly.ecommercestore.request.system;

import lombok.Data;

@Data
public class ImageProductRequest {

    private String url;

    public ImageProductRequest() {
    }

    public ImageProductRequest(String url) {
        this.url = url;
    }
}
