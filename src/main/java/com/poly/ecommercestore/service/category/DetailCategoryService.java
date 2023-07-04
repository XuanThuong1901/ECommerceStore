package com.poly.ecommercestore.service.category;

import com.poly.ecommercestore.entity.Categories;
import com.poly.ecommercestore.entity.DetailCategories;
import com.poly.ecommercestore.repository.CategoryRepository;
import com.poly.ecommercestore.repository.DetailCategoryRepository;
import com.poly.ecommercestore.repository.ProductRepository;
import com.poly.ecommercestore.request.system.DetailCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailCategoryService implements IDetailCategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DetailCategoryRepository detailCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public DetailCategories addListDetailCategory(DetailCategoryRequest detailCategory) {

//        Categories category = categoryRepository.getCategoriesById(detailCategory.getIDCategory());
//        if(category == null){
//            return null;
//        }
//
//        DetailCategories newDetailCategory = new DetailCategories(detailCategory.getDetailCategoryName(), category);
//        detailCategoryRepository.save(newDetailCategory);
//
//        return newDetailCategory;

        return null;
    }

    @Override
    public List<DetailCategories> getDetailCategoriesByIDCategory(int iDCategory) {
        return detailCategoryRepository.getDetailCategoriesByCategory(iDCategory);
    }

    @Override
    public Boolean removeDetailCategory(int iDDetailCategory) {
        if(productRepository.getProductsByDetailCategory(iDDetailCategory) != null)
            return false;

        detailCategoryRepository.deleteById(iDDetailCategory);
        return true;
    }


}
