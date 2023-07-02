package com.poly.ecommercestore.request;

import lombok.Data;

@Data
public class CategoryRequest {

    private String categoryName;

    public CategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }
}
