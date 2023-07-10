package com.poly.ecommercestore.service.supplier;

import com.poly.ecommercestore.entity.Suppliers;
import com.poly.ecommercestore.DTO.system.SupplierDTO;

import java.util.List;

public interface ISupplierService {

    Suppliers addSupplier(SupplierDTO supplier);

    List<Suppliers> getAllSupplier();

    Suppliers updateSupplier(SupplierDTO supplier, int iDSupplier);

    Boolean deleteSupplier(int iDSupplier);
}
