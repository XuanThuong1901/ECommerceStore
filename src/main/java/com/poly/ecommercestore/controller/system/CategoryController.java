package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.entity.Categories;
import com.poly.ecommercestore.repository.CategoryRepository;
import com.poly.ecommercestore.repository.DetailCategoryRepository;
import com.poly.ecommercestore.request.system.CategoryRequest;
import com.poly.ecommercestore.service.category.CategoryService;
import com.poly.ecommercestore.service.category.DetailCategoryService;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DetailCategoryService detailCategoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest category){
        if(category.getCategoryName() == null)
            return ResponseEntity.badRequest().body("Category name null");
        if(category.getDetailCategory() == null)
            return ResponseEntity.badRequest().body("CategoryDetail null");
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<?> removeCategory(@PathVariable(value = "id") int iDCategory){
        if(categoryRepository.findById(iDCategory) == null)
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);

        Boolean check = categoryService.removeCategory(iDCategory);
        if(!check)
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);

        return ResponseEntity.ok(ECommerceMessage.CATEGORY_DELETED);
    }

//    @PostMapping("/update/{id}")
//    public ResponseEntity<?> updateCategory(@PathVariable(value = "id") int iDCategory){
//        if(categoryRepository.findById(iDCategory) == null)
//            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);
//
//    }
}
