package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.repository.ProductRepository;
import com.poly.ecommercestore.request.system.ProductRequest;
import com.poly.ecommercestore.service.product.ProductService;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    private final int SIZE = 14;

    @GetMapping("/{page}")
    public ResponseEntity<?> getProductByPage(@PathVariable(value = "page") int page){
        return ResponseEntity.ok(productService.getProductByPage(page, SIZE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(ProductRequest product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

//    @PostMapping("/update")
//    public ResponseEntity<?> updateProduct(ProductRequest product){
//        return ResponseEntity.ok(productService.addProduct(product));
//    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        if(productRepository.getReferenceById(id) == null)
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);

        productService.removeProduct(id);
        return ResponseEntity.ok(ECommerceMessage.PRODUCT_DELETED);
    }


}
