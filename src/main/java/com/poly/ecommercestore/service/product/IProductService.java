package com.poly.ecommercestore.service.product;

import com.poly.ecommercestore.entity.Products;
import com.poly.ecommercestore.DTO.system.ProductDTO;
import org.springframework.data.domain.Page;

public interface IProductService {

    Products addProduct(ProductDTO product, String iDEmployer);

    Boolean updateProduct(ProductDTO product, int iDProduct);

    Boolean removeProduct(int iDProduct);

    Products getProductById(int iDProduct);

    Page<Products> getProductByPage(int page, int size);

    Page<Products> getProductByCategoryByPage(int iDDetailCategory, int page, int size);

}
