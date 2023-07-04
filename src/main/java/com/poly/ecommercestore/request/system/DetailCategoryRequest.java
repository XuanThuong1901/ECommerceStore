package com.poly.ecommercestore.request.system;

import lombok.Data;

@Data
public class DetailCategoryRequest {

    private String detailCategoryName;

    public DetailCategoryRequest() {
    }

    public DetailCategoryRequest(String detailCategoryName) {
        this.detailCategoryName = detailCategoryName;
    }
}
