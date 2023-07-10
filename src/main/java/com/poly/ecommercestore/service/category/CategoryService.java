package com.poly.ecommercestore.service.category;

import com.poly.ecommercestore.entity.Categories;
import com.poly.ecommercestore.repository.CategoryRepository;
import com.poly.ecommercestore.DTO.system.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Categories addCategory(CategoryDTO category) {
        if(categoryRepository.getCategoriesByName(category.getCategoryName()) != null){
            return null;
        }

        Categories newCategory = new Categories(category.getCategoryName(), category.getLevel(), category.getOrigin());


        categoryRepository.save(newCategory);


        return newCategory;
    }

    @Override
    public List<Categories> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Boolean removeCategory(int iDCategory) {
        Categories category = categoryRepository.getCategoriesById(iDCategory);



//        categoryRepository.deleteById(iDCategory);
        return true;
    }
}
