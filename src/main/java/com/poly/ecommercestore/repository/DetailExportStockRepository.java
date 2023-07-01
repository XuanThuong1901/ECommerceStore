//package com.poly.ecommercestore.repository;
//
//import com.poly.ecommercestore.entity.DetailCategories;
//import com.poly.ecommercestore.entity.DetailExportStocks;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DetailExportStockRepository extends JpaRepository<DetailExportStocks, Integer> {
//
//    @Query("SELECT detailExportStock FROM DetailExportStocks detailExportStock WHERE detailExportStock.exportStock.iDExportStock = :iDExportStock")
//    public List<DetailExportStocks> getDetailExportStocks(int iDExportStock);
//}
