package com.poly.ecommercestore.service.supplier;

import com.poly.ecommercestore.entity.Suppliers;
import com.poly.ecommercestore.request.system.SupplierRequest;

import java.util.List;

public interface ISupplierService {

    Suppliers addSupplier(SupplierRequest supplier);

    List<Suppliers> getAllSupplier();

    Suppliers updateSupplier(SupplierRequest supplier, int iDSupplier);

    Boolean deleteSupplier(int iDSupplier);
}
