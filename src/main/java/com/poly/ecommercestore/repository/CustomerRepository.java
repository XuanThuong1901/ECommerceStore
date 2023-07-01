package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {

    @Query("SELECT customer FROM Customers customer WHERE customer.iDCustomer = :iDCustomer")
    public Customers getCustomersById(String iDCustomer);
}
