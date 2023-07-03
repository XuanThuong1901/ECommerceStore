package com.poly.ecommercestore.service.category;

import com.poly.ecommercestore.entity.DetailCategories;
import com.poly.ecommercestore.request.system.DetailCategoryRequest;

import java.util.List;

public interface IDetailCategoryService {

    DetailCategories addListDetailCategory(DetailCategoryRequest detailCategory);

    List<DetailCategories> getDetailCategoriesByIDCategory(int iDCategory);

    Boolean removeDetailCategory(int iDDetailCategory);

}
