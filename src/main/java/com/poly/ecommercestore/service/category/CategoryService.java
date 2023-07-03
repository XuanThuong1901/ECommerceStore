package com.poly.ecommercestore.service.category;

import com.poly.ecommercestore.entity.Categories;
import com.poly.ecommercestore.entity.DetailCategories;
import com.poly.ecommercestore.repository.CategoryRepository;
import com.poly.ecommercestore.repository.DetailCategoryRepository;
import com.poly.ecommercestore.request.system.CategoryRequest;
import com.poly.ecommercestore.request.system.DetailCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DetailCategoryRepository detailCategoryRepository;

    @Override
    public Categories addCategory(CategoryRequest category) {
        if(categoryRepository.getCategoriesByName(category.getCategoryName()) != null){
            return null;
        }

        Categories newCategory = new Categories(category.getCategoryName());
        List<DetailCategories> detailCategoriesList = new ArrayList<>();

        for (DetailCategoryRequest detailCategory : category.getDetailCategory()){
            DetailCategories detailCategoryTemp = new DetailCategories(detailCategory.getDetailCategoryName(), newCategory);
            detailCategoriesList.add(detailCategoryTemp);
        }

        detailCategoryRepository.saveAll(detailCategoriesList);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public List<Categories> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Boolean removeCategory(int iDCategory) {
        if(detailCategoryRepository.getDetailCategoriesByCategory(iDCategory) != null)
            return false;

        categoryRepository.deleteById(iDCategory);
        return true;
    }
}
