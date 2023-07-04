package com.poly.ecommercestore.request.system;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryRequest {

    private String categoryName;
    private List<DetailCategoryRequest> detailCategory;

    public CategoryRequest(String categoryName, List<DetailCategoryRequest> detailCategory) {
        this.categoryName = categoryName;
        this.detailCategory = (detailCategory != null) ? detailCategory : new ArrayList<>();
    }
}
