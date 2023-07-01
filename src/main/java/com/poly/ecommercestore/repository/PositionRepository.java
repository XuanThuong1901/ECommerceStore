package com.poly.ecommercestore.repository;

import com.poly.ecommercestore.entity.Employers;
import com.poly.ecommercestore.entity.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Positions, Integer> {

    @Query("SELECT position FROM Positions position WHERE position.iDPosition = :iDPosition")
    public Positions getPositionById(@Param("iDPosition") int iDPosition);
}
