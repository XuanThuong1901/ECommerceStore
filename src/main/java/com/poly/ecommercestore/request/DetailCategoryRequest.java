package com.poly.ecommercestore.request;

import lombok.Data;

@Data
public class DetailCategoryRequest {

    private String detailCategoryName;
    private int iDCategory;

    public DetailCategoryRequest(String detailCategoryName, int iDCategory) {
        this.detailCategoryName = detailCategoryName;
        this.iDCategory = iDCategory;
    }
}
