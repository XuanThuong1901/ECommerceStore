package com.poly.ecommercestore.service.supplier;

import com.poly.ecommercestore.entity.Suppliers;
import com.poly.ecommercestore.repository.SupplierRepository;
import com.poly.ecommercestore.DTO.system.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Suppliers addSupplier(SupplierDTO supplier) {
        Suppliers newSupplier = new Suppliers(supplier.getSupplierName(), supplier.getEmail(), supplier.getTelephone(), supplier.getAddress());

        supplierRepository.save(newSupplier);

        return newSupplier;
    }

    @Override
    public List<Suppliers> getAllSupplier() {
        return supplierRepository.findAll();
    }

    @Override
    public Suppliers updateSupplier(SupplierDTO supplier, int iDSupplier) {
        Suppliers updateSupplier = supplierRepository.getReferenceById(iDSupplier);
        if(updateSupplier == null)
            return null;

        updateSupplier.setSupplierName(supplier.getSupplierName());
        updateSupplier.setEmail(supplier.getEmail());
        updateSupplier.setTelephone(supplier.getTelephone());
        updateSupplier.setAddress(supplier.getAddress());

        supplierRepository.save(updateSupplier);

        return updateSupplier;
    }

    @Override
    public Boolean deleteSupplier(int iDSupplier) {

        if(supplierRepository.getReferenceById(iDSupplier) == null)
            return false;

        supplierRepository.deleteById(iDSupplier);
        return true;
    }
}
