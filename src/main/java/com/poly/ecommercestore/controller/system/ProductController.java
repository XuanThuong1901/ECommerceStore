package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.repository.ProductRepository;
import com.poly.ecommercestore.DTO.system.ProductDTO;
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

    @GetMapping("/detailCategory={id}/{page}")
    public ResponseEntity<?> getProductByDetailCategoryByPage(@PathVariable(value = "id") int id, @PathVariable(value = "page") int page){
        return ResponseEntity.ok(productService.getProductByCategoryByPage(id, page, SIZE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/add/employer={id}")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO product, @PathVariable(value = "id") String iDEmp){
        System.out.println(product);
        if(product.getProductName() == null){
            return ResponseEntity.badRequest().body("Product not name");
        }
        if(product.getQuantity() == null){
            return ResponseEntity.badRequest().body("Product not quantity");
        }
        if(product.getPriceListDTOS() == null){
            return ResponseEntity.badRequest().body("Product not price");
        }
        if(product.getImageProduct() == null){
            return ResponseEntity.badRequest().body("Product not image");
        }
        if(product.getSpecification() == null){
            return ResponseEntity.badRequest().body("Product not specification");
        }

        productService.addProduct(product, iDEmp);
        return ResponseEntity.ok("Product created");
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
