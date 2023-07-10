package com.poly.ecommercestore.DTO.system;

import lombok.Data;

@Data
public class CategoryDTO {

    private String categoryName;
    private int level;
    private int origin;

    public CategoryDTO(String categoryName, int level, int origin) {
        this.categoryName = categoryName;
        this.level = level;
        this.origin = origin;
    }
}
