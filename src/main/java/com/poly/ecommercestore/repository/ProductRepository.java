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

    @Query("SELECT product FROM Products product WHERE product.detailCategory.iDDetailCategory = :iDDetailCategory")
    List<Products> getProductsByDetailCategory(@Param("iDDetailCategory") int iDDetailCategory);

    @Query("SELECT product FROM Products product WHERE product.detailCategory.iDDetailCategory = :iDDetailCategory ORDER BY product.iDProduct ASC")
    Page<Products> getProductsByDetailCategoryByPage(@Param("iDDetailCategory") int iDDetailCategory, Pageable pageable);

    @Query("SELECT product FROM Products product ORDER BY product.iDProduct ASC")
    Page<Products> getProductsByPage(Pageable pageable);

}
