package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.Positions;
import com.poly.ecommercestore.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Query("SELECT status FROM Status status WHERE status.iDStatus = :iDStatus")
    public Status getStatusById(@Param("iDStatus") int iDStatus);
}
