package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.StatusOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrders, Integer> {

}
