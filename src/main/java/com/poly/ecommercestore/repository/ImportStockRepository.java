package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.ImportStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ImportStockRepository extends JpaRepository<ImportStocks, Integer> {


}
