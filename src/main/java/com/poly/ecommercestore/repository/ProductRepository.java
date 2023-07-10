package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT product FROM Products product WHERE product.category.iDCategory = :iDCategory")
    List<Products> getProductsByCategory(@Param("iDCategory") int iDCategory);

    @Query("SELECT product FROM Products product WHERE product.category.iDCategory = :iDCategory ORDER BY product.iDProduct ASC")
    Page<Products> getProductsByCategoryByPage(@Param("iDCategory") int iDCategory, Pageable pageable);

    @Query("SELECT product FROM Products product ORDER BY product.iDProduct ASC")
    Page<Products> getProductsByPage(Pageable pageable);

}
