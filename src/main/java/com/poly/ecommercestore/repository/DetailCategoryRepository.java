//package com.poly.ecommercestore.repository;
//
//import com.poly.ecommercestore.entity.Customers;
//import com.poly.ecommercestore.entity.DetailCategories;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DetailCategoryRepository extends JpaRepository<DetailCategories, Integer> {
//
//    @Query("SELECT detailCategory FROM DetailCategories detailCategory WHERE detailCategory.category.iDCategory = :iDCategory")
//    public List<DetailCategories> getDetailCategoriesByCategory(int iDCategory);
//}
