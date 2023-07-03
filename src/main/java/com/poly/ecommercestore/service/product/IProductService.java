package com.poly.ecommercestore.service.product;

import com.poly.ecommercestore.entity.Products;
import com.poly.ecommercestore.request.system.ProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    Products addProduct(ProductRequest product);

    Boolean updateProduct(ProductRequest product, int iDProduct);

    Boolean removeProduct(int iDProduct);

    Products getProductById(int iDProduct);

    Page<Products> getProductByPage(int page, int size);

    Page<Products> getProductByDetailCategoryByPage(int iDDetailCategory, int page, int size);

}
