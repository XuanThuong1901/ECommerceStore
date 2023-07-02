package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT product FROM Products product WHERE product.detailCategory.iDDetailCategory = :iDDetailCategory")
    List<Products> getProductsByDetailCategory(int iDDetailCategory);
}
