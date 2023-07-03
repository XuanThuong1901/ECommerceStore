package com.poly.ecommercestore.service.category;

import com.poly.ecommercestore.entity.Categories;
import com.poly.ecommercestore.request.system.CategoryRequest;

import java.util.List;

public interface ICategoryService {

    Categories addCategory(CategoryRequest category);

    List<Categories> getAll();

    Boolean removeCategory(int iDCategory);
}
