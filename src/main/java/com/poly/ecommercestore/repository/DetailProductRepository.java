//package com.poly.ecommercestore.repository;
//
//import com.poly.ecommercestore.entity.DetailOrders;
//import com.poly.ecommercestore.entity.DetailProducts;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DetailProductRepository extends JpaRepository<DetailProducts, Integer> {
//
//    @Query("SELECT detailProduct FROM DetailProducts detailProduct WHERE detailProduct.product.iDProduct = :iDProduct")
//    public List<DetailProducts> getDetailProducts(int iDProduct);
//}
